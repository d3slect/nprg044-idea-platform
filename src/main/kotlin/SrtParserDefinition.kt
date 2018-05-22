package cz.cuni.mff.d3s.srtplugin

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import cz.cuni.mff.d3s.srtplugin.psi.SrtFile
import cz.cuni.mff.d3s.srtplugin.psi.SrtTypes


class SrtParserDefinition : ParserDefinition {

    private companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val FILE = IFileElementType(SrtLanguage)
    }

    override fun createLexer(project: Project) = SrtLexerAdapter()

    override fun getWhitespaceTokens() = WHITE_SPACES

    override fun getCommentTokens() = TokenSet.EMPTY

    override fun getStringLiteralElements() = TokenSet.EMPTY

    override fun createParser(project: Project): PsiParser = SrtParser()

    override fun getFileNodeType() = FILE

    override fun createFile(viewProvider: FileViewProvider) = SrtFile(viewProvider)

    override fun spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode) = SpaceRequirements.MAY

    override fun createElement(node: ASTNode) = SrtTypes.Factory.createElement(node)
}