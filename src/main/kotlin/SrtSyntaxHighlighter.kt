package cz.cuni.mff.d3s.srtplugin

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import cz.cuni.mff.d3s.srtplugin.psi.SrtTypes


class SrtSyntaxHighlighter : SyntaxHighlighterBase() {

    companion object {
        val COUNTER = createTextAttributesKey("SRT_COUNTER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val TIME = createTextAttributesKey("SRT_TIME", DefaultLanguageHighlighterColors.CONSTANT)
        val ARROW = createTextAttributesKey("SRT_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val TEXT_WITH_NEWLINES = createTextAttributesKey("SRT_KEY", DefaultLanguageHighlighterColors.STRING)
        val BAD_CHARACTER = createTextAttributesKey("SRT_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val COUNTER_KEYS = arrayOf(COUNTER)
        private val TIME_KEYS = arrayOf(TIME)
        private val ARROW_KEYS = arrayOf(ARROW)
        private val TEXT_WITH_NEWLINES_KEYS = arrayOf(TEXT_WITH_NEWLINES)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val EMPTY_KEYS =  emptyArray<TextAttributesKey>()
    }

    override fun getHighlightingLexer() = SrtLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            SrtTypes.COUNTER -> COUNTER_KEYS
            SrtTypes.TIME -> TIME_KEYS
            SrtTypes.ARROW -> ARROW_KEYS
            SrtTypes.TEXT_WITH_NEWLINES -> TEXT_WITH_NEWLINES_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

}