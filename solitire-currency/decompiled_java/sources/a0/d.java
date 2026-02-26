package a0;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: Contexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @NotNull
    public static final Drawable a(@NotNull Context context, @DrawableRes int i10) {
        Drawable drawable = AppCompatResources.getDrawable(context, i10);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i10).toString());
    }

    @NotNull
    public static final Drawable b(@NotNull Resources resources, @DrawableRes int i10, @Nullable Resources.Theme theme) {
        Drawable drawable = ResourcesCompat.getDrawable(resources, i10, theme);
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException(("Invalid resource ID: " + i10).toString());
    }

    @Nullable
    public static final Lifecycle c(@Nullable Context context) {
        Object baseContext = context;
        while (!(baseContext instanceof LifecycleOwner)) {
            if (!(baseContext instanceof ContextWrapper)) {
                return null;
            }
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
        }
        return ((LifecycleOwner) baseContext).getLifecycle();
    }

    @NotNull
    public static final Drawable d(@NotNull Context context, @NotNull Resources resources, @XmlRes int i10) throws XmlPullParserException, IOException {
        XmlResourceParser xml = resources.getXml(i10);
        int next = xml.next();
        while (next != 2 && next != 1) {
            next = xml.next();
        }
        if (next != 2) {
            throw new XmlPullParserException("No start tag found.");
        }
        if (Build.VERSION.SDK_INT < 24) {
            String name = xml.getName();
            if (kotlin.jvm.internal.t.d(name, "vector")) {
                return VectorDrawableCompat.createFromXmlInner(resources, (XmlPullParser) xml, Xml.asAttributeSet(xml), context.getTheme());
            }
            if (kotlin.jvm.internal.t.d(name, "animated-vector")) {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, resources, xml, Xml.asAttributeSet(xml), context.getTheme());
            }
        }
        return b(resources, i10, context.getTheme());
    }

    public static final boolean e(@NotNull Context context, @NotNull String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }
}
