// This is a generated file. Not intended for manual editing.
package cz.cuni.mff.d3s.srtplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static cz.cuni.mff.d3s.srtplugin.psi.SrtTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import cz.cuni.mff.d3s.srtplugin.psi.*;

public class SrtSubtitleImpl extends ASTWrapperPsiElement implements SrtSubtitle {

  public SrtSubtitleImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SrtVisitor visitor) {
    visitor.visitSubtitle(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SrtVisitor) accept((SrtVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SrtTimeRange getTimeRange() {
    return findNotNullChildByClass(SrtTimeRange.class);
  }

}
