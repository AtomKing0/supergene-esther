package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.material.Strings;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Strings.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Strings_androidKt {
    @Composable
    @NotNull
    /* JADX INFO: renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m1145getString4foXLRw(int i10, @Nullable Composer composer, int i11) {
        String string;
        composer.startReplaceableGroup(-726638443);
        composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources();
        Strings.Companion companion = Strings.Companion;
        if (Strings.m1134equalsimpl0(i10, companion.m1142getNavigationMenuUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.navigation_menu);
            t.h(string, "resources.getString(R.string.navigation_menu)");
        } else if (Strings.m1134equalsimpl0(i10, companion.m1138getCloseDrawerUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.close_drawer);
            t.h(string, "resources.getString(R.string.close_drawer)");
        } else if (Strings.m1134equalsimpl0(i10, companion.m1139getCloseSheetUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.close_sheet);
            t.h(string, "resources.getString(R.string.close_sheet)");
        } else if (Strings.m1134equalsimpl0(i10, companion.m1140getDefaultErrorMessageUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.default_error_message);
            t.h(string, "resources.getString(R.st…ng.default_error_message)");
        } else if (Strings.m1134equalsimpl0(i10, companion.m1141getExposedDropdownMenuUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.dropdown_menu);
            t.h(string, "resources.getString(R.string.dropdown_menu)");
        } else if (Strings.m1134equalsimpl0(i10, companion.m1144getSliderRangeStartUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.range_start);
            t.h(string, "resources.getString(R.string.range_start)");
        } else if (Strings.m1134equalsimpl0(i10, companion.m1143getSliderRangeEndUdPEhr4())) {
            string = resources.getString(androidx.compose.ui.R.string.range_end);
            t.h(string, "resources.getString(R.string.range_end)");
        } else {
            string = "";
        }
        composer.endReplaceableGroup();
        return string;
    }
}
