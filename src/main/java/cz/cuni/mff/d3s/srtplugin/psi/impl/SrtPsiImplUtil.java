package cz.cuni.mff.d3s.srtplugin.psi.impl;

import com.intellij.lang.ASTNode;
import cz.cuni.mff.d3s.srtplugin.psi.SrtSubtitle;
import cz.cuni.mff.d3s.srtplugin.psi.SrtTypes;

public class SrtPsiImplUtil {
    public static String getCounter(SrtSubtitle element) {
        ASTNode counterNode = element.getNode().findChildByType(SrtTypes.COUNTER);
        if (counterNode == null) {
            return null;
        }

        return counterNode.getText();
    }

    public static ASTNode getCounterNode(SrtSubtitle element) {
        return element.getNode().findChildByType(SrtTypes.COUNTER);
    }

    public static String getTextContent(SrtSubtitle element) {
        ASTNode node = element.getNode().findChildByType(SrtTypes.TEXT_WITH_NEWLINES);
        if (node == null) {
            return null;
        }

        return node.getText();
    }
}
