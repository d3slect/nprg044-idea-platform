package cz.cuni.mff.d3s.srtplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import cz.cuni.mff.d3s.srtplugin.psi.SrtTypes;
import com.intellij.psi.TokenType;

%%

%class SrtLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
COUNTER=\d+
ARROW=" --> "
TIME=\d{2}:\d{2}:\d{2},\d{3}
LINE=[^\n\r]+

%state AFTER_ARROW
%state BEFORE_TEXT

%%

<YYINITIAL> {COUNTER}   { yybegin(YYINITIAL); return SrtTypes.COUNTER; }
<YYINITIAL> {TIME}      { yybegin(YYINITIAL); return SrtTypes.TIME; }
<YYINITIAL> {ARROW}     { yybegin(AFTER_ARROW); return SrtTypes.ARROW; }

<AFTER_ARROW> {TIME}    { yybegin(BEFORE_TEXT); return SrtTypes.TIME; }

<BEFORE_TEXT> {LINE}({CRLF}{LINE})* { yybegin(YYINITIAL); return SrtTypes.TEXT_WITH_NEWLINES; }

{CRLF} { return SrtTypes.CRLF; }
.   { return TokenType.BAD_CHARACTER; }
