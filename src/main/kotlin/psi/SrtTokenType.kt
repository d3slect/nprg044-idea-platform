package cz.cuni.mff.d3s.srtplugin.psi

import com.intellij.psi.tree.IElementType
import cz.cuni.mff.d3s.srtplugin.SrtLanguage
import org.jetbrains.annotations.NonNls


class SrtTokenType(@NonNls debugName: String) : IElementType(debugName, SrtLanguage) {

    override fun toString(): String {
        return "SrtTokenType." + super.toString()
    }
}
