package cz.cuni.mff.d3s.srtplugin

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import cz.cuni.mff.d3s.srtplugin.psi.SrtSubtitle
import cz.cuni.mff.d3s.srtplugin.psi.SrtTypes


class SrtAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {

        if (element is SrtSubtitle) {
            val prev = PsiTreeUtil.findSiblingBackward(element, SrtTypes.SUBTITLE, null)

            if (prev == null) {
                checkFirstSubtitle(element, holder)
            } else if (prev is SrtSubtitle) {
                checkNonFirstSubtitle(element, prev, holder)
            }
        }
    }

    private fun checkFirstSubtitle(element: SrtSubtitle, holder: AnnotationHolder) {
        // check counter == 1
        if (element.counter != null && !element.counter.contentEquals("1")) {
            holder.createErrorAnnotation(element.counterNode.textRange, "First subtitle must have number \"1\"")
        }
    }

    private fun checkNonFirstSubtitle(element: SrtSubtitle, prev: SrtSubtitle, holder: AnnotationHolder) {
        // check current counter == prev. counter + 1
        if (element.counter != null && prev.counter != null) {
            val counterVal = element.counter.toInt()
            val expectedVal = prev.counter.toInt() + 1

            if (counterVal != expectedVal) {
                holder.createErrorAnnotation(element.counterNode.textRange, "Subtitle must have number \"${expectedVal}\"")
                        .registerFix(CounterQuickFix())
            }
        }
    }
}