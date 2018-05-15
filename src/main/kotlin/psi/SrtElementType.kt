package cz.cuni.mff.d3s.srtplugin.psi

import com.intellij.psi.tree.IElementType
import cz.cuni.mff.d3s.srtplugin.SrtLanguage
import org.jetbrains.annotations.NonNls

class SrtElementType(@NonNls debugName: String) : IElementType(debugName, SrtLanguage)