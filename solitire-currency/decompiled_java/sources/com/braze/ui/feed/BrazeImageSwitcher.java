package com.braze.ui.feed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageSwitcher;
import androidx.annotation.VisibleForTesting;
import com.braze.support.BrazeLogger;
import com.braze.ui.R$styleable;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BrazeImageSwitcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BrazeImageSwitcher extends ImageSwitcher {

    @Nullable
    private Drawable readIcon;

    @Nullable
    private Drawable unReadIcon;

    /* JADX INFO: renamed from: com.braze.ui.feed.BrazeImageSwitcher$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeImageSwitcher.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Error while checking for custom drawable.";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrazeImageSwitcher(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Drawable drawable;
        super(context, attributeSet);
        t.i(context, "context");
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.com_braze_ui_feed_BrazeImageSwitcher);
            t.h(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…_feed_BrazeImageSwitcher)");
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.com_braze_ui_feed_BrazeImageSwitcher_brazeFeedCustomReadIcon) {
                    Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(index);
                    if (drawable2 != null) {
                        this.readIcon = drawable2;
                    }
                } else if (typedArrayObtainStyledAttributes.getIndex(i10) == R$styleable.com_braze_ui_feed_BrazeImageSwitcher_brazeFeedCustomUnReadIcon && (drawable = typedArrayObtainStyledAttributes.getDrawable(index)) != null) {
                    this.unReadIcon = drawable;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (a) AnonymousClass1.INSTANCE, 4, (Object) null);
        }
    }

    @Nullable
    public final Drawable getReadIcon() {
        return this.readIcon;
    }

    @Nullable
    public final Drawable getUnReadIcon() {
        return this.unReadIcon;
    }

    @VisibleForTesting
    public final void setReadIcon(@Nullable Drawable drawable) {
        this.readIcon = drawable;
    }

    @VisibleForTesting
    public final void setUnReadIcon(@Nullable Drawable drawable) {
        this.unReadIcon = drawable;
    }
}
