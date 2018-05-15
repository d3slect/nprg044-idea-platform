// This is a generated file. Not intended for manual editing.
package cz.cuni.mff.d3s.srtplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import cz.cuni.mff.d3s.srtplugin.psi.impl.*;

public interface SrtTypes {

  IElementType SUBTITLE = new SrtElementType("SUBTITLE");
  IElementType TIME_RANGE = new SrtElementType("TIME_RANGE");

  IElementType ARROW = new SrtTokenType("ARROW");
  IElementType COUNTER = new SrtTokenType("COUNTER");
  IElementType CRLF = new SrtTokenType("CRLF");
  IElementType TEXT_WITH_NEWLINES = new SrtTokenType("TEXT_WITH_NEWLINES");
  IElementType TIME = new SrtTokenType("TIME");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == SUBTITLE) {
        return new SrtSubtitleImpl(node);
      }
      else if (type == TIME_RANGE) {
        return new SrtTimeRangeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
