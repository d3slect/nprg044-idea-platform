package cz.cuni.mff.d3s.srtplugin

import com.intellij.lexer.FlexAdapter
import java.io.Reader


class SrtLexerAdapter : FlexAdapter(SrtLexer(null as Reader?))
