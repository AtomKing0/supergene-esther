package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import androidx.annotation.DrawableRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParserException;
import p9.r;

/* JADX INFO: compiled from: PainterResources.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PainterResources_androidKt {

    @NotNull
    private static final String errorMessage = "Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG";

    private static final ImageBitmap loadImageBitmapResource(Resources resources, int i10) {
        return ImageResources_androidKt.imageResource(ImageBitmap.Companion, resources, i10);
    }

    @Composable
    private static final ImageVector loadVectorResource(Resources.Theme theme, Resources resources, int i10, Composer composer, int i11) throws XmlPullParserException {
        composer.startReplaceableGroup(2112503116);
        ImageVectorCache imageVectorCache = (ImageVectorCache) composer.consume(AndroidCompositionLocals_androidKt.getLocalImageVectorCache());
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i10);
        ImageVectorCache.ImageVectorEntry imageVectorEntryLoadVectorResourceInner = imageVectorCache.get(key);
        if (imageVectorEntryLoadVectorResourceInner == null) {
            XmlResourceParser xml = resources.getXml(i10);
            t.h(xml, "res.getXml(id)");
            if (!t.d(XmlVectorParser_androidKt.seekToStartTag(xml).getName(), "vector")) {
                throw new IllegalArgumentException(errorMessage);
            }
            imageVectorEntryLoadVectorResourceInner = VectorResources_androidKt.loadVectorResourceInner(theme, resources, xml);
            imageVectorCache.set(key, imageVectorEntryLoadVectorResourceInner);
        }
        ImageVector imageVector = imageVectorEntryLoadVectorResourceInner.getImageVector();
        composer.endReplaceableGroup();
        return imageVector;
    }

    @Composable
    @NotNull
    public static final Painter painterResource(@DrawableRes int i10, @Nullable Composer composer, int i11) {
        Painter bitmapPainter;
        composer.startReplaceableGroup(473971343);
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Resources res = context.getResources();
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new TypedValue();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        TypedValue typedValue = (TypedValue) objRememberedValue;
        res.getValue(i10, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && r.V(charSequence, ".xml", false, 2, null)) {
            composer.startReplaceableGroup(-738265321);
            Resources.Theme theme = context.getTheme();
            t.h(theme, "context.theme");
            t.h(res, "res");
            bitmapPainter = VectorPainterKt.rememberVectorPainter(loadVectorResource(theme, res, i10, composer, ((i11 << 6) & 896) | 72), composer, 0);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-738265196);
            Object objValueOf = Integer.valueOf(i10);
            composer.startReplaceableGroup(511388516);
            boolean zChanged = composer.changed(objValueOf) | composer.changed(charSequence);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                t.h(res, "res");
                objRememberedValue2 = loadImageBitmapResource(res, i10);
                composer.updateRememberedValue(objRememberedValue2);
            }
            composer.endReplaceableGroup();
            bitmapPainter = new BitmapPainter((ImageBitmap) objRememberedValue2, 0L, 0L, 6, null);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return bitmapPainter;
    }
}
