package u4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import e4.k;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final ColorStateList f34594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final ColorStateList f34595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final ColorStateList f34596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f34597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f34599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f34600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f34601h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f34602i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f34603j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f34604k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f34605l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private ColorStateList f34606m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f34607n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @FontRes
    private final int f34608o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f34609p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Typeface f34610q;

    /* JADX INFO: compiled from: TextAppearance.java */
    class a extends ResourcesCompat.FontCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f34611a;

        a(f fVar) {
            this.f34611a = fVar;
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        /* JADX INFO: renamed from: onFontRetrievalFailed */
        public void lambda$callbackFailAsync$1(int i10) {
            d.this.f34609p = true;
            this.f34611a.a(i10);
        }

        @Override // androidx.core.content.res.ResourcesCompat.FontCallback
        /* JADX INFO: renamed from: onFontRetrieved */
        public void lambda$callbackSuccessAsync$0(@NonNull Typeface typeface) {
            d dVar = d.this;
            dVar.f34610q = Typeface.create(typeface, dVar.f34598e);
            d.this.f34609p = true;
            this.f34611a.b(d.this.f34610q, false);
        }
    }

    /* JADX INFO: compiled from: TextAppearance.java */
    class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f34613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextPaint f34614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f34615c;

        b(Context context, TextPaint textPaint, f fVar) {
            this.f34613a = context;
            this.f34614b = textPaint;
            this.f34615c = fVar;
        }

        @Override // u4.f
        public void a(int i10) {
            this.f34615c.a(i10);
        }

        @Override // u4.f
        public void b(@NonNull Typeface typeface, boolean z10) {
            d.this.p(this.f34613a, this.f34614b, typeface);
            this.f34615c.b(typeface, z10);
        }
    }

    public d(@NonNull Context context, @StyleRes int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, k.Z4);
        l(typedArrayObtainStyledAttributes.getDimension(k.f24924a5, 0.0f));
        k(c.a(context, typedArrayObtainStyledAttributes, k.f24948d5));
        this.f34594a = c.a(context, typedArrayObtainStyledAttributes, k.f24956e5);
        this.f34595b = c.a(context, typedArrayObtainStyledAttributes, k.f24964f5);
        this.f34598e = typedArrayObtainStyledAttributes.getInt(k.f24940c5, 0);
        this.f34599f = typedArrayObtainStyledAttributes.getInt(k.f24932b5, 1);
        int iE = c.e(typedArrayObtainStyledAttributes, k.f25012l5, k.f25004k5);
        this.f34608o = typedArrayObtainStyledAttributes.getResourceId(iE, 0);
        this.f34597d = typedArrayObtainStyledAttributes.getString(iE);
        this.f34600g = typedArrayObtainStyledAttributes.getBoolean(k.f25020m5, false);
        this.f34596c = c.a(context, typedArrayObtainStyledAttributes, k.f24972g5);
        this.f34601h = typedArrayObtainStyledAttributes.getFloat(k.f24980h5, 0.0f);
        this.f34602i = typedArrayObtainStyledAttributes.getFloat(k.f24988i5, 0.0f);
        this.f34603j = typedArrayObtainStyledAttributes.getFloat(k.f24996j5, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i10, k.f25074t3);
        int i11 = k.f25082u3;
        this.f34604k = typedArrayObtainStyledAttributes2.hasValue(i11);
        this.f34605l = typedArrayObtainStyledAttributes2.getFloat(i11, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f34610q == null && (str = this.f34597d) != null) {
            this.f34610q = Typeface.create(str, this.f34598e);
        }
        if (this.f34610q == null) {
            int i10 = this.f34599f;
            if (i10 == 1) {
                this.f34610q = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f34610q = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f34610q = Typeface.DEFAULT;
            } else {
                this.f34610q = Typeface.MONOSPACE;
            }
            this.f34610q = Typeface.create(this.f34610q, this.f34598e);
        }
    }

    private boolean m(Context context) {
        if (e.a()) {
            return true;
        }
        int i10 = this.f34608o;
        return (i10 != 0 ? ResourcesCompat.getCachedFont(context, i10) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f34610q;
    }

    @NonNull
    @VisibleForTesting
    public Typeface f(@NonNull Context context) {
        if (this.f34609p) {
            return this.f34610q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.f34608o);
                this.f34610q = font;
                if (font != null) {
                    this.f34610q = Typeface.create(font, this.f34598e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d("TextAppearance", "Error loading font " + this.f34597d, e10);
            }
        }
        d();
        this.f34609p = true;
        return this.f34610q;
    }

    public void g(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(@NonNull Context context, @NonNull f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i10 = this.f34608o;
        if (i10 == 0) {
            this.f34609p = true;
        }
        if (this.f34609p) {
            fVar.b(this.f34610q, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i10, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f34609p = true;
            fVar.a(1);
        } catch (Exception e10) {
            Log.d("TextAppearance", "Error loading font " + this.f34597d, e10);
            this.f34609p = true;
            fVar.a(-3);
        }
    }

    @Nullable
    public ColorStateList i() {
        return this.f34606m;
    }

    public float j() {
        return this.f34607n;
    }

    public void k(@Nullable ColorStateList colorStateList) {
        this.f34606m = colorStateList;
    }

    public void l(float f10) {
        this.f34607n = f10;
    }

    public void n(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f34606m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f10 = this.f34603j;
        float f11 = this.f34601h;
        float f12 = this.f34602i;
        ColorStateList colorStateList2 = this.f34596c;
        textPaint.setShadowLayer(f10, f11, f12, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        Typeface typefaceA = h.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i10 = this.f34598e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i10 & 1) != 0);
        textPaint.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f34607n);
        if (this.f34604k) {
            textPaint.setLetterSpacing(this.f34605l);
        }
    }
}
