package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class i<TranscodeType> extends k1.a<i<TranscodeType>> {
    protected static final k1.f O = new k1.f().f(u0.j.f34323c).S(f.LOW).a0(true);
    private final Context A;
    private final j B;
    private final Class<TranscodeType> C;
    private final b D;
    private final d E;

    @NonNull
    private k<?, ? super TranscodeType> F;

    @Nullable
    private Object G;

    @Nullable
    private List<k1.e<TranscodeType>> H;

    @Nullable
    private i<TranscodeType> I;

    @Nullable
    private i<TranscodeType> J;

    @Nullable
    private Float K;
    private boolean L = true;
    private boolean M;
    private boolean N;

    /* JADX INFO: compiled from: RequestBuilder.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f8224b;

        static {
            int[] iArr = new int[f.values().length];
            f8224b = iArr;
            try {
                iArr[f.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8224b[f.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8224b[f.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8224b[f.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f8223a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8223a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8223a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8223a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8223a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8223a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8223a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8223a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    protected i(@NonNull b bVar, j jVar, Class<TranscodeType> cls, Context context) {
        this.D = bVar;
        this.B = jVar;
        this.C = cls;
        this.A = context;
        this.F = jVar.o(cls);
        this.E = bVar.i();
        p0(jVar.m());
        b(jVar.n());
    }

    private k1.c k0(l1.h<TranscodeType> hVar, @Nullable k1.e<TranscodeType> eVar, k1.a<?> aVar, Executor executor) {
        return l0(new Object(), hVar, eVar, null, this.F, aVar.u(), aVar.r(), aVar.q(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private k1.c l0(Object obj, l1.h<TranscodeType> hVar, @Nullable k1.e<TranscodeType> eVar, @Nullable k1.d dVar, k<?, ? super TranscodeType> kVar, f fVar, int i10, int i11, k1.a<?> aVar, Executor executor) {
        k1.d dVar2;
        k1.d bVar;
        if (this.J != null) {
            bVar = new k1.b(obj, dVar);
            dVar2 = bVar;
        } else {
            dVar2 = null;
            bVar = dVar;
        }
        k1.c cVarM0 = m0(obj, hVar, eVar, bVar, kVar, fVar, i10, i11, aVar, executor);
        if (dVar2 == null) {
            return cVarM0;
        }
        int iR = this.J.r();
        int iQ = this.J.q();
        if (o1.k.r(i10, i11) && !this.J.K()) {
            iR = aVar.r();
            iQ = aVar.q();
        }
        i<TranscodeType> iVar = this.J;
        k1.b bVar2 = dVar2;
        bVar2.p(cVarM0, iVar.l0(obj, hVar, eVar, bVar2, iVar.F, iVar.u(), iR, iQ, this.J, executor));
        return bVar2;
    }

    private k1.c m0(Object obj, l1.h<TranscodeType> hVar, k1.e<TranscodeType> eVar, @Nullable k1.d dVar, k<?, ? super TranscodeType> kVar, f fVar, int i10, int i11, k1.a<?> aVar, Executor executor) {
        i<TranscodeType> iVar = this.I;
        if (iVar == null) {
            if (this.K == null) {
                return z0(obj, hVar, eVar, aVar, dVar, kVar, fVar, i10, i11, executor);
            }
            k1.i iVar2 = new k1.i(obj, dVar);
            iVar2.p(z0(obj, hVar, eVar, aVar, iVar2, kVar, fVar, i10, i11, executor), z0(obj, hVar, eVar, aVar.d().Z(this.K.floatValue()), iVar2, kVar, o0(fVar), i10, i11, executor));
            return iVar2;
        }
        if (this.N) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        k<?, ? super TranscodeType> kVar2 = iVar.L ? kVar : iVar.F;
        f fVarU = iVar.D() ? this.I.u() : o0(fVar);
        int iR = this.I.r();
        int iQ = this.I.q();
        if (o1.k.r(i10, i11) && !this.I.K()) {
            iR = aVar.r();
            iQ = aVar.q();
        }
        k1.i iVar3 = new k1.i(obj, dVar);
        k1.c cVarZ0 = z0(obj, hVar, eVar, aVar, iVar3, kVar, fVar, i10, i11, executor);
        this.N = true;
        i<TranscodeType> iVar4 = this.I;
        k1.c cVarL0 = iVar4.l0(obj, hVar, eVar, iVar3, kVar2, fVarU, iR, iQ, iVar4, executor);
        this.N = false;
        iVar3.p(cVarZ0, cVarL0);
        return iVar3;
    }

    @NonNull
    private f o0(@NonNull f fVar) {
        int i10 = a.f8224b[fVar.ordinal()];
        if (i10 == 1) {
            return f.NORMAL;
        }
        if (i10 == 2) {
            return f.HIGH;
        }
        if (i10 == 3 || i10 == 4) {
            return f.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + u());
    }

    @SuppressLint({"CheckResult"})
    private void p0(List<k1.e<Object>> list) {
        Iterator<k1.e<Object>> it = list.iterator();
        while (it.hasNext()) {
            h0((k1.e) it.next());
        }
    }

    private <Y extends l1.h<TranscodeType>> Y s0(@NonNull Y y10, @Nullable k1.e<TranscodeType> eVar, k1.a<?> aVar, Executor executor) {
        o1.j.d(y10);
        if (!this.M) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        k1.c cVarK0 = k0(y10, eVar, aVar, executor);
        k1.c request = y10.getRequest();
        if (cVarK0.g(request) && !u0(aVar, request)) {
            if (!((k1.c) o1.j.d(request)).isRunning()) {
                request.j();
            }
            return y10;
        }
        this.B.l(y10);
        y10.a(cVarK0);
        this.B.v(y10, cVarK0);
        return y10;
    }

    private boolean u0(k1.a<?> aVar, k1.c cVar) {
        return !aVar.C() && cVar.h();
    }

    @NonNull
    private i<TranscodeType> y0(@Nullable Object obj) {
        this.G = obj;
        this.M = true;
        return this;
    }

    private k1.c z0(Object obj, l1.h<TranscodeType> hVar, k1.e<TranscodeType> eVar, k1.a<?> aVar, k1.d dVar, k<?, ? super TranscodeType> kVar, f fVar, int i10, int i11, Executor executor) {
        Context context = this.A;
        d dVar2 = this.E;
        return k1.h.w(context, dVar2, obj, this.G, this.C, aVar, i10, i11, fVar, hVar, eVar, this.H, dVar, dVar2.f(), kVar.c(), executor);
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> h0(@Nullable k1.e<TranscodeType> eVar) {
        if (eVar != null) {
            if (this.H == null) {
                this.H = new ArrayList();
            }
            this.H.add(eVar);
        }
        return this;
    }

    @Override // k1.a
    @NonNull
    @CheckResult
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public i<TranscodeType> b(@NonNull k1.a<?> aVar) {
        o1.j.d(aVar);
        return (i) super.b(aVar);
    }

    @Override // k1.a
    @CheckResult
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public i<TranscodeType> d() {
        i<TranscodeType> iVar = (i) super.d();
        iVar.F = iVar.F.clone();
        return iVar;
    }

    @NonNull
    public <Y extends l1.h<TranscodeType>> Y q0(@NonNull Y y10) {
        return (Y) r0(y10, null, o1.e.b());
    }

    @NonNull
    <Y extends l1.h<TranscodeType>> Y r0(@NonNull Y y10, @Nullable k1.e<TranscodeType> eVar, Executor executor) {
        return (Y) s0(y10, eVar, this, executor);
    }

    @NonNull
    public l1.i<ImageView, TranscodeType> t0(@NonNull ImageView imageView) {
        k1.a aVarM;
        o1.k.a();
        o1.j.d(imageView);
        if (!J() && H() && imageView.getScaleType() != null) {
            switch (a.f8223a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarM = d().M();
                    break;
                case 2:
                    aVarM = d().N();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarM = d().O();
                    break;
                case 6:
                    aVarM = d().N();
                    break;
                default:
                    aVarM = this;
                    break;
            }
        } else {
            aVarM = this;
        }
        return (l1.i) s0(this.E.a(imageView, this.C), null, aVarM, o1.e.b());
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> v0(@Nullable k1.e<TranscodeType> eVar) {
        this.H = null;
        return h0(eVar);
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> w0(@Nullable Object obj) {
        return y0(obj);
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> x0(@Nullable String str) {
        return y0(str);
    }
}
