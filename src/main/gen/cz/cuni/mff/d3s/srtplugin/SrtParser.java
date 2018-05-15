// This is a generated file. Not intended for manual editing.
package cz.cuni.mff.d3s.srtplugin;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static cz.cuni.mff.d3s.srtplugin.psi.SrtTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SrtParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == SUBTITLE) {
      r = subtitle(b, 0);
    }
    else if (t == TIME_RANGE) {
      r = timeRange(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return srtFile(b, l + 1);
  }

  /* ********************************************************** */
  // subtitle (CRLF subtitle)*
  static boolean srtFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srtFile")) return false;
    if (!nextTokenIs(b, COUNTER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subtitle(b, l + 1);
    r = r && srtFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (CRLF subtitle)*
  private static boolean srtFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srtFile_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!srtFile_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "srtFile_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // CRLF subtitle
  private static boolean srtFile_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srtFile_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CRLF);
    r = r && subtitle(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COUNTER CRLF
  //              timeRange CRLF
  //              TEXT_WITH_NEWLINES CRLF
  public static boolean subtitle(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subtitle")) return false;
    if (!nextTokenIs(b, COUNTER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COUNTER, CRLF);
    r = r && timeRange(b, l + 1);
    r = r && consumeTokens(b, 0, CRLF, TEXT_WITH_NEWLINES, CRLF);
    exit_section_(b, m, SUBTITLE, r);
    return r;
  }

  /* ********************************************************** */
  // TIME ARROW TIME
  public static boolean timeRange(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "timeRange")) return false;
    if (!nextTokenIs(b, TIME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TIME, ARROW, TIME);
    exit_section_(b, m, TIME_RANGE, r);
    return r;
  }

}
