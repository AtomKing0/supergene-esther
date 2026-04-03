package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.q;

/* JADX INFO: compiled from: TextDrawStyle.kt */
/* JADX INFO: loaded from: classes.dex */
public interface TextDrawStyle {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: androidx.compose.ui.text.style.TextDrawStyle$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: TextDrawStyle.kt */
    public final /* synthetic */ class CC {
        @NotNull
        public static TextDrawStyle a(TextDrawStyle textDrawStyle, @NotNull TextDrawStyle other) {
            t.i(other, "other");
            return other.getBrush() != null ? other : textDrawStyle.getBrush() != null ? textDrawStyle : other.takeOrElse(textDrawStyle.new AnonymousClass1());
        }

        @NotNull
        public static TextDrawStyle b(TextDrawStyle textDrawStyle, @NotNull a other) {
            t.i(other, "other");
            return !t.d(textDrawStyle, Unspecified.INSTANCE) ? textDrawStyle : (TextDrawStyle) other.invoke();
        }
    }

    /* JADX INFO: compiled from: TextDrawStyle.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        public final TextDrawStyle from(@Nullable Brush brush) {
            if (brush == null) {
                return Unspecified.INSTANCE;
            }
            if (brush instanceof SolidColor) {
                return m3611from8_81llA(((SolidColor) brush).m1867getValue0d7_KjU());
            }
            if (brush instanceof ShaderBrush) {
                return new BrushStyle((ShaderBrush) brush);
            }
            throw new q();
        }

        @NotNull
        /* JADX INFO: renamed from: from-8_81llA, reason: not valid java name */
        public final TextDrawStyle m3611from8_81llA(long j10) {
            return (j10 > Color.Companion.m1634getUnspecified0d7_KjU() ? 1 : (j10 == Color.Companion.m1634getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? new ColorStyle(j10, null) : Unspecified.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: TextDrawStyle.kt */
    public static final class Unspecified implements TextDrawStyle {

        @NotNull
        public static final Unspecified INSTANCE = new Unspecified();

        private Unspecified() {
        }

        @Override // androidx.compose.ui.text.style.TextDrawStyle
        @Nullable
        public Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.TextDrawStyle
        /* JADX INFO: renamed from: getColor-0d7_KjU */
        public long mo3556getColor0d7_KjU() {
            return Color.Companion.m1634getUnspecified0d7_KjU();
        }

        @Override // androidx.compose.ui.text.style.TextDrawStyle
        public /* synthetic */ TextDrawStyle merge(TextDrawStyle textDrawStyle) {
            return CC.a(this, textDrawStyle);
        }

        @Override // androidx.compose.ui.text.style.TextDrawStyle
        public /* synthetic */ TextDrawStyle takeOrElse(a aVar) {
            return CC.b(this, aVar);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.style.TextDrawStyle$merge$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextDrawStyle.kt */
    static final class AnonymousClass1 extends v implements a<TextDrawStyle> {
        AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final TextDrawStyle invoke() {
            return TextDrawStyle.this;
        }
    }

    @Nullable
    Brush getBrush();

    /* JADX INFO: renamed from: getColor-0d7_KjU */
    long mo3556getColor0d7_KjU();

    @NotNull
    TextDrawStyle merge(@NotNull TextDrawStyle textDrawStyle);

    @NotNull
    TextDrawStyle takeOrElse(@NotNull a<? extends TextDrawStyle> aVar);
}
