package cz.cuni.mff.d3s.srtplugin

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage

class SrtColorSettingsPage : ColorSettingsPage {

    companion object {
        private val DESCRIPTORS = arrayOf(
                AttributesDescriptor("Counter", SrtSyntaxHighlighter.COUNTER),
                AttributesDescriptor("Time", SrtSyntaxHighlighter.TIME),
                AttributesDescriptor("Arrow", SrtSyntaxHighlighter.ARROW),
                AttributesDescriptor("Text", SrtSyntaxHighlighter.TEXT_WITH_NEWLINES)
        )
    }

    override fun getIcon() = SrtIcons.FILE

    override fun getHighlighter() = SrtSyntaxHighlighter()

    override fun getDemoText(): String {
        return """
               1
               00:00:54,300 --> 00:00:56,600
               Last orders, please.

               2
               00:01:03,500 --> 00:01:05,500
               - Shaun.
               - Yeah?

               3
               00:01:05,600 --> 00:01:08,800
               - Do you see what I'm saying?
               - Yeah, totally.

               """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? {
        return null
    }

    override fun getAttributeDescriptors() = DESCRIPTORS

    override fun getColorDescriptors() = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName() = "Srt"
}