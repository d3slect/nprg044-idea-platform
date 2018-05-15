package cz.cuni.mff.d3s.srtplugin

import com.intellij.openapi.fileTypes.LanguageFileType

object SrtFileType : LanguageFileType(SrtLanguage) {
    override fun getName() = "Srt file"
    override fun getDescription() = "Srt language file"
    override fun getDefaultExtension() = "srt"
    override fun getIcon() = SrtIcons.FILE
}