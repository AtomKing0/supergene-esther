package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.room.RoomDatabase;
import com.ironsource.gi;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v8.l f20269a = v8.n.a(c.f20301g);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NumberFormat f20270b = NumberFormat.getPercentInstance();

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseInLineTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {946, 947, 948, 949, 950, 951, 953, 954}, m = "invokeSuspend")
    public static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20271j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20272k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20273l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20274m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20275n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20276o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20277p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20278q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20279r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ List f20280s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ List f20281t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ List f20282u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, kotlin.jvm.internal.n0 n0Var3, kotlin.jvm.internal.n0 n0Var4, kotlin.jvm.internal.n0 n0Var5, List list, List list2, List list3) {
            super(2, dVar);
            this.f20274m = xmlPullParser;
            this.f20275n = n0Var;
            this.f20276o = n0Var2;
            this.f20277p = n0Var3;
            this.f20278q = n0Var4;
            this.f20279r = n0Var5;
            this.f20280s = list;
            this.f20281t = list2;
            this.f20282u = list3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f20274m, dVar, this.f20275n, this.f20276o, this.f20277p, this.f20278q, this.f20279r, this.f20280s, this.f20281t, this.f20282u);
            aVar.f20273l = obj;
            return aVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:122:0x0246  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0191  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x01e7 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x01f6 -> B:105:0x01f9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x0207 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:116:0x0221 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:118:0x023a -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00bd -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c7 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00cf -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00d6 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00e1 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x010d -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0130 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:65:0x0153 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0176 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x01a1 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x01c3 -> B:121:0x023f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x01dd -> B:121:0x023f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 650
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseTagsTextOnly")
    public static final class a0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20283j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20284k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f20285l;

        public a0(z8.d<? super a0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20284k = obj;
            this.f20285l |= Integer.MIN_VALUE;
            return m.p(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseWrapperTag")
    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20286j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20287k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20288l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20289m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20290n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f20291o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public /* synthetic */ Object f20292p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f20293q;

        public b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20292p = obj;
            this.f20293q |= Integer.MIN_VALUE;
            return m.v(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseCreativeTag")
    public static final class b0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20294j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20295k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20296l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20297m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20298n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public /* synthetic */ Object f20299o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f20300p;

        public b0(z8.d<? super b0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20299o = obj;
            this.f20300p |= Integer.MIN_VALUE;
            return m.T(null, false, this);
        }
    }

    public static final class c extends kotlin.jvm.internal.v implements h9.a<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f20301g = new c();

        public c() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l invoke() {
            return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l();
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseTrackingEventsTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {946}, m = "invokeSuspend")
    public static final class c0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20302j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20303k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20304l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20305m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ List f20306n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(XmlPullParser xmlPullParser, z8.d dVar, List list) {
            super(2, dVar);
            this.f20305m = xmlPullParser;
            this.f20306n = list;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((c0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            c0 c0Var = new c0(this.f20305m, dVar, this.f20306n);
            c0Var.f20304l = obj;
            return c0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e0  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006a -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0085 -> B:32:0x008a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a1 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00bb -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d4 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 235
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.c0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseInLineTag")
    public static final class d extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20307j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20308k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20309l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20310m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20311n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f20312o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Object f20313p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Object f20314q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public /* synthetic */ Object f20315r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f20316s;

        public d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20315r = obj;
            this.f20316s |= Integer.MIN_VALUE;
            return m.k(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCreativesTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {946}, m = "invokeSuspend")
    public static final class d0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20317j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20318k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20319l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20320m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f20321n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ List f20322o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(XmlPullParser xmlPullParser, z8.d dVar, boolean z10, List list) {
            super(2, dVar);
            this.f20320m = xmlPullParser;
            this.f20321n = z10;
            this.f20322o = list;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((d0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            d0 d0Var = new d0(this.f20320m, dVar, this.f20321n, this.f20322o);
            d0Var.f20319l = obj;
            return d0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:51:0x00db). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006a -> B:51:0x00db). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:51:0x00db). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0087 -> B:32:0x008c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a3 -> B:51:0x00db). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00bd -> B:51:0x00db). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d6 -> B:51:0x00db). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 237
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.d0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseLinearTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {947, 948, 949, 950, 951, 952}, m = "invokeSuspend")
    public static final class e extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20323j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20324k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20325l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20326m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20327n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20328o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20329p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ List f20330q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ List f20331r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20332s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ boolean f20333t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ List f20334u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, kotlin.jvm.internal.n0 n0Var3, List list, List list2, kotlin.jvm.internal.n0 n0Var4, boolean z10, List list3) {
            super(2, dVar);
            this.f20326m = xmlPullParser;
            this.f20327n = n0Var;
            this.f20328o = n0Var2;
            this.f20329p = n0Var3;
            this.f20330q = list;
            this.f20331r = list2;
            this.f20332s = n0Var4;
            this.f20333t = z10;
            this.f20334u = list3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((e) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            e eVar = new e(this.f20326m, dVar, this.f20327n, this.f20328o, this.f20329p, this.f20330q, this.f20331r, this.f20332s, this.f20333t, this.f20334u);
            eVar.f20325l = obj;
            return eVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:105:0x01ff  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0189  */
        /* JADX WARN: Type inference failed for: r2v34, types: [T, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t] */
        /* JADX WARN: Type inference failed for: r2v38, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v42, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v20, types: [T, java.lang.Long] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x01f3 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00af -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00b9 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c1 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00c7 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d2 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00f8 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x010c -> B:51:0x0111). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x011d -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0142 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0167 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0193 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x01b8 -> B:104:0x01f8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x01da -> B:104:0x01f8). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 566
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseTrackingEventsTag")
    public static final class e0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20335j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20336k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f20337l;

        public e0(z8.d<? super e0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20336k = obj;
            this.f20337l |= Integer.MIN_VALUE;
            return m.q(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseAdParametersTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {}, m = "invokeSuspend")
    public static final class f extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20338j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20339k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20340l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20341m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20342n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2) {
            super(2, dVar);
            this.f20340l = xmlPullParser;
            this.f20341m = n0Var;
            this.f20342n = n0Var2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((f) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            f fVar = new f(this.f20340l, dVar, this.f20341m, this.f20342n);
            fVar.f20339k = obj;
            return fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws XmlPullParserException, IOException {
            String text;
            a9.d.e();
            if (this.f20338j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            kotlinx.coroutines.p0.g((kotlinx.coroutines.o0) this.f20339k);
            if (m.m0(this.f20340l)) {
                this.f20340l.nextTag();
            }
            if (m.h0(this.f20340l)) {
                return v8.k0.f35197a;
            }
            if (!m.o0(this.f20340l)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.f20340l.getDepth();
            while (this.f20340l.getDepth() >= depth) {
                int depth2 = this.f20340l.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        m.o0(this.f20340l);
                    }
                } else if (m.o0(this.f20340l)) {
                    XmlPullParser xmlPullParser = this.f20340l;
                    kotlin.jvm.internal.n0 n0Var = this.f20341m;
                    String strG = m.G(xmlPullParser, "xmlEncoded");
                    n0Var.f29834a = strG != null ? kotlin.coroutines.jvm.internal.b.a(Boolean.parseBoolean(strG)) : 0;
                } else if (m.q0(this.f20340l) && (text = this.f20340l.getText()) != null && !p9.q.z(text)) {
                    String text2 = this.f20340l.getText();
                    kotlin.jvm.internal.t.h(text2, "text");
                    this.f20342n.f29834a = p9.r.b1(text2).toString();
                } else if (m.k0(this.f20340l)) {
                    return v8.k0.f35197a;
                }
                this.f20340l.next();
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseCreativesTag")
    public static final class f0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20343j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20344k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f20345l;

        public f0(z8.d<? super f0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20344k = obj;
            this.f20345l |= Integer.MIN_VALUE;
            return m.Z(null, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseLinearTag")
    public static final class g extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f20346j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20347k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20348l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20349m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20350n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f20351o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Object f20352p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Object f20353q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public /* synthetic */ Object f20354r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f20355s;

        public g(z8.d<? super g> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20354r = obj;
            this.f20355s |= Integer.MIN_VALUE;
            return m.d0(null, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseTrackingTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {}, m = "invokeSuspend")
    public static final class g0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20356j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20357k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20358l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20359m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20360n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20361o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, kotlin.jvm.internal.n0 n0Var3) {
            super(2, dVar);
            this.f20358l = xmlPullParser;
            this.f20359m = n0Var;
            this.f20360n = n0Var2;
            this.f20361o = n0Var3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((g0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            g0 g0Var = new g0(this.f20358l, dVar, this.f20359m, this.f20360n, this.f20361o);
            g0Var.f20357k = obj;
            return g0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws XmlPullParserException, IOException {
            String text;
            a9.d.e();
            if (this.f20356j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            kotlinx.coroutines.p0.g((kotlinx.coroutines.o0) this.f20357k);
            if (m.m0(this.f20358l)) {
                this.f20358l.nextTag();
            }
            if (m.h0(this.f20358l)) {
                return v8.k0.f35197a;
            }
            if (!m.o0(this.f20358l)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.f20358l.getDepth();
            while (this.f20358l.getDepth() >= depth) {
                int depth2 = this.f20358l.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        m.o0(this.f20358l);
                    }
                } else if (m.o0(this.f20358l)) {
                    XmlPullParser xmlPullParser = this.f20358l;
                    kotlin.jvm.internal.n0 n0Var = this.f20359m;
                    String strG = m.G(xmlPullParser, NotificationCompat.CATEGORY_EVENT);
                    n0Var.f29834a = strG != null ? m.i0(strG) : 0;
                    kotlin.jvm.internal.n0 n0Var2 = this.f20360n;
                    String strG2 = m.G(xmlPullParser, TypedValues.CycleType.S_WAVE_OFFSET);
                    n0Var2.f29834a = strG2 != null ? m.a0(strG2) : 0;
                } else if (m.q0(this.f20358l) && (text = this.f20358l.getText()) != null && !p9.q.z(text)) {
                    String text2 = this.f20358l.getText();
                    kotlin.jvm.internal.t.h(text2, "text");
                    this.f20361o.f29834a = p9.r.b1(text2).toString();
                } else if (m.k0(this.f20358l)) {
                    return v8.k0.f35197a;
                }
                this.f20358l.next();
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseAdParametersTag")
    public static final class h extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20362j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20363k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20364l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f20365m;

        public h(z8.d<? super h> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20364l = obj;
            this.f20365m |= Integer.MIN_VALUE;
            return m.F0(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {799}, m = "parseHtmlResourceTag")
    public static final class h0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f20366j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20367k;

        public h0(z8.d<? super h0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20366j = obj;
            this.f20367k |= Integer.MIN_VALUE;
            return m.e(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseMediaFileTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {}, m = "invokeSuspend")
    public static final class i extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20368j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20369k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20370l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20371m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20372n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20373o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20374p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20375q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20376r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20377s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20378t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20379u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20380v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20381w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20382x;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, kotlin.jvm.internal.n0 n0Var3, kotlin.jvm.internal.n0 n0Var4, kotlin.jvm.internal.n0 n0Var5, kotlin.jvm.internal.n0 n0Var6, kotlin.jvm.internal.n0 n0Var7, kotlin.jvm.internal.n0 n0Var8, kotlin.jvm.internal.n0 n0Var9, kotlin.jvm.internal.n0 n0Var10, kotlin.jvm.internal.n0 n0Var11, kotlin.jvm.internal.n0 n0Var12) {
            super(2, dVar);
            this.f20370l = xmlPullParser;
            this.f20371m = n0Var;
            this.f20372n = n0Var2;
            this.f20373o = n0Var3;
            this.f20374p = n0Var4;
            this.f20375q = n0Var5;
            this.f20376r = n0Var6;
            this.f20377s = n0Var7;
            this.f20378t = n0Var8;
            this.f20379u = n0Var9;
            this.f20380v = n0Var10;
            this.f20381w = n0Var11;
            this.f20382x = n0Var12;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((i) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            i iVar = new i(this.f20370l, dVar, this.f20371m, this.f20372n, this.f20373o, this.f20374p, this.f20375q, this.f20376r, this.f20377s, this.f20378t, this.f20379u, this.f20380v, this.f20381w, this.f20382x);
            iVar.f20369k = obj;
            return iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v17, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.Boolean] */
        /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws XmlPullParserException, IOException {
            String text;
            a9.d.e();
            if (this.f20368j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            kotlinx.coroutines.p0.g((kotlinx.coroutines.o0) this.f20369k);
            if (m.m0(this.f20370l)) {
                this.f20370l.nextTag();
            }
            if (m.h0(this.f20370l)) {
                return v8.k0.f35197a;
            }
            if (!m.o0(this.f20370l)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.f20370l.getDepth();
            while (this.f20370l.getDepth() >= depth) {
                int depth2 = this.f20370l.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        m.o0(this.f20370l);
                    }
                } else if (m.o0(this.f20370l)) {
                    XmlPullParser xmlPullParser = this.f20370l;
                    this.f20371m.f29834a = m.G(xmlPullParser, "id");
                    this.f20372n.f29834a = kotlin.coroutines.jvm.internal.b.a(kotlin.jvm.internal.t.d(m.G(xmlPullParser, gi.f12296h), "progressive"));
                    this.f20373o.f29834a = m.G(xmlPullParser, "type");
                    kotlin.jvm.internal.n0 n0Var = this.f20374p;
                    String strG = m.G(xmlPullParser, "width");
                    n0Var.f29834a = strG != null ? p9.p.l(strG) : 0;
                    kotlin.jvm.internal.n0 n0Var2 = this.f20375q;
                    String strG2 = m.G(xmlPullParser, "height");
                    n0Var2.f29834a = strG2 != null ? p9.p.l(strG2) : 0;
                    this.f20376r.f29834a = m.G(xmlPullParser, "codec");
                    kotlin.jvm.internal.n0 n0Var3 = this.f20377s;
                    String strG3 = m.G(xmlPullParser, "bitrate");
                    n0Var3.f29834a = strG3 != null ? p9.p.l(strG3) : 0;
                    kotlin.jvm.internal.n0 n0Var4 = this.f20378t;
                    String strG4 = m.G(xmlPullParser, "minBitrate");
                    n0Var4.f29834a = strG4 != null ? p9.p.l(strG4) : 0;
                    kotlin.jvm.internal.n0 n0Var5 = this.f20379u;
                    String strG5 = m.G(xmlPullParser, "maxBitrate");
                    n0Var5.f29834a = strG5 != null ? p9.p.l(strG5) : 0;
                    kotlin.jvm.internal.n0 n0Var6 = this.f20380v;
                    String strG6 = m.G(xmlPullParser, "scalable");
                    n0Var6.f29834a = strG6 != null ? kotlin.coroutines.jvm.internal.b.a(Boolean.parseBoolean(strG6)) : 0;
                    this.f20381w.f29834a = m.G(xmlPullParser, "apiFramework");
                } else if (m.q0(this.f20370l) && (text = this.f20370l.getText()) != null && !p9.q.z(text)) {
                    String text2 = this.f20370l.getText();
                    kotlin.jvm.internal.t.h(text2, "text");
                    this.f20382x.f29834a = p9.r.b1(text2).toString();
                } else if (m.k0(this.f20370l)) {
                    return v8.k0.f35197a;
                }
                this.f20370l.next();
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseTrackingTag")
    public static final class i0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20383j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20384k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20385l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f20386m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f20387n;

        public i0(z8.d<? super i0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20386m = obj;
            this.f20387n |= Integer.MIN_VALUE;
            return m.r(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseAdSystemTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {}, m = "invokeSuspend")
    public static final class j extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20388j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20389k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20390l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20391m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20392n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2) {
            super(2, dVar);
            this.f20390l = xmlPullParser;
            this.f20391m = n0Var;
            this.f20392n = n0Var2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((j) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            j jVar = new j(this.f20390l, dVar, this.f20391m, this.f20392n);
            jVar.f20389k = obj;
            return jVar;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws XmlPullParserException, IOException {
            String text;
            a9.d.e();
            if (this.f20388j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            kotlinx.coroutines.p0.g((kotlinx.coroutines.o0) this.f20389k);
            if (m.m0(this.f20390l)) {
                this.f20390l.nextTag();
            }
            if (m.h0(this.f20390l)) {
                return v8.k0.f35197a;
            }
            if (!m.o0(this.f20390l)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.f20390l.getDepth();
            while (this.f20390l.getDepth() >= depth) {
                int depth2 = this.f20390l.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        m.o0(this.f20390l);
                    }
                } else if (m.o0(this.f20390l)) {
                    this.f20391m.f29834a = m.G(this.f20390l, "version");
                } else if (m.q0(this.f20390l) && (text = this.f20390l.getText()) != null && !p9.q.z(text)) {
                    String text2 = this.f20390l.getText();
                    kotlin.jvm.internal.t.h(text2, "text");
                    this.f20392n.f29834a = p9.r.b1(text2).toString();
                } else if (m.k0(this.f20390l)) {
                    return v8.k0.f35197a;
                }
                this.f20390l.next();
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {802}, m = "parseIFrameResourceTag")
    public static final class j0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public /* synthetic */ Object f20393j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20394k;

        public j0(z8.d<? super j0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20393j = obj;
            this.f20394k |= Integer.MIN_VALUE;
            return m.f(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseMediaFileTag")
    public static final class k extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20395j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20396k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20397l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20398m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20399n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f20400o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Object f20401p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Object f20402q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f20403r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Object f20404s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Object f20405t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Object f20406u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public /* synthetic */ Object f20407v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f20408w;

        public k(z8.d<? super k> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20407v = obj;
            this.f20408w |= Integer.MIN_VALUE;
            return m.l(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVast$2", f = "VastParser.kt", l = {130}, m = "invokeSuspend")
    public static final class k0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20409j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20410k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(XmlPullParser xmlPullParser, z8.d<? super k0> dVar) {
            super(2, dVar);
            this.f20410k = xmlPullParser;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y> dVar) {
            return ((k0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new k0(this.f20410k, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f20409j;
            if (i10 == 0) {
                v8.u.b(obj);
                XmlPullParser xmlPullParser = this.f20410k;
                this.f20409j = 1;
                obj = m.t(xmlPullParser, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return obj;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseAdSystemTag")
    public static final class l extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20411j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20412k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20413l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f20414m;

        public l(z8.d<? super l> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20413l = obj;
            this.f20414m |= Integer.MIN_VALUE;
            return m.G0(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseIconClicksTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {946, 947}, m = "invokeSuspend")
    public static final class l0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20415j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20416k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20417l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20418m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20419n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ List f20420o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, List list) {
            super(2, dVar);
            this.f20418m = xmlPullParser;
            this.f20419n = n0Var;
            this.f20420o = list;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((l0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            l0 l0Var = new l0(this.f20418m, dVar, this.f20419n, this.f20420o);
            l0Var.f20417l = obj;
            return l0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0115  */
        /* JADX WARN: Type inference failed for: r4v22, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0072 -> B:60:0x010e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007c -> B:60:0x010e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ad -> B:60:0x010e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00bd -> B:42:0x00c2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d6 -> B:60:0x010e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00f0 -> B:60:0x010e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0109 -> B:60:0x010e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 288
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.l0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$m, reason: collision with other inner class name */
    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseMediaFilesTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {946}, m = "invokeSuspend")
    public static final class C0427m extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20421j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20422k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20423l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20424m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ List f20425n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0427m(XmlPullParser xmlPullParser, z8.d dVar, List list) {
            super(2, dVar);
            this.f20424m = xmlPullParser;
            this.f20425n = list;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((C0427m) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C0427m c0427m = new C0427m(this.f20424m, dVar, this.f20425n);
            c0427m.f20423l = obj;
            return c0427m;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e0  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006a -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0085 -> B:32:0x008a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a1 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00bb -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d4 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 235
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.C0427m.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVastTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {947, 948}, m = "invokeSuspend")
    public static final class m0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20426j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20427k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20428l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20429m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20430n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20431o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ List f20432p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, List list) {
            super(2, dVar);
            this.f20429m = xmlPullParser;
            this.f20430n = n0Var;
            this.f20431o = n0Var2;
            this.f20432p = list;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((m0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            m0 m0Var = new m0(this.f20429m, dVar, this.f20430n, this.f20431o, this.f20432p);
            m0Var.f20428l = obj;
            return m0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0121  */
        /* JADX WARN: Type inference failed for: r4v18, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r4v24, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0072 -> B:60:0x011a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007c -> B:60:0x011a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ad -> B:60:0x011a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00bd -> B:42:0x00c2). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00d8 -> B:60:0x011a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00fc -> B:60:0x011a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0115 -> B:60:0x011a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 300
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.m0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseAdTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {949, 950}, m = "invokeSuspend")
    public static final class n extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20433j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20434k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20435l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20436m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20437n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20438o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20439p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, kotlin.jvm.internal.n0 n0Var3) {
            super(2, dVar);
            this.f20436m = xmlPullParser;
            this.f20437n = n0Var;
            this.f20438o = n0Var2;
            this.f20439p = n0Var3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((n) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            n nVar = new n(this.f20436m, dVar, this.f20437n, this.f20438o, this.f20439p);
            nVar.f20435l = obj;
            return nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x013a  */
        /* JADX WARN: Type inference failed for: r5v18, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0078 -> B:66:0x0133). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0082 -> B:66:0x0133). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008a -> B:66:0x0133). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ca -> B:45:0x00cf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00dd -> B:50:0x00de). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00e9 -> B:66:0x0133). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0115 -> B:66:0x0133). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x012e -> B:66:0x0133). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 325
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.n.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseIconClicksTag")
    public static final class n0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20440j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20441k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20442l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f20443m;

        public n0(z8.d<? super n0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20442l = obj;
            this.f20443m |= Integer.MIN_VALUE;
            return m.g(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseMediaFilesTag")
    public static final class o extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20444j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20445k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f20446l;

        public o(z8.d<? super o> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20445k = obj;
            this.f20446l |= Integer.MIN_VALUE;
            return m.m(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseVastTag")
    public static final class o0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20447j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20448k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20449l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f20450m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f20451n;

        public o0(z8.d<? super o0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20450m = obj;
            this.f20451n |= Integer.MIN_VALUE;
            return m.t(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseAdTag")
    public static final class p extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20452j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20453k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20454l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f20455m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f20456n;

        public p(z8.d<? super p> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20455m = obj;
            this.f20456n |= Integer.MIN_VALUE;
            return m.a(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseIconTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {953, 955, 956, 962, 963}, m = "invokeSuspend")
    public static final class p0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20457j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20458k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20459l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20460m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20461n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20462o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20463p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20464q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20465r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20466s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20467t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20468u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ List f20469v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Object f20470w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, kotlin.jvm.internal.n0 n0Var3, kotlin.jvm.internal.n0 n0Var4, kotlin.jvm.internal.n0 n0Var5, kotlin.jvm.internal.n0 n0Var6, kotlin.jvm.internal.n0 n0Var7, kotlin.jvm.internal.n0 n0Var8, List list) {
            super(2, dVar);
            this.f20460m = xmlPullParser;
            this.f20461n = n0Var;
            this.f20462o = n0Var2;
            this.f20463p = n0Var3;
            this.f20464q = n0Var4;
            this.f20465r = n0Var5;
            this.f20466s = n0Var6;
            this.f20467t = n0Var7;
            this.f20468u = n0Var8;
            this.f20469v = list;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((p0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            p0 p0Var = new p0(this.f20460m, dVar, this.f20461n, this.f20462o, this.f20463p, this.f20464q, this.f20465r, this.f20466s, this.f20467t, this.f20468u, this.f20469v);
            p0Var.f20459l = obj;
            return p0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:128:0x026e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x010b  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x013a  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x01c1  */
        /* JADX WARN: Type inference failed for: r10v11, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r10v21, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v35, types: [T, java.lang.Long] */
        /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x0249 -> B:127:0x0267). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:0x0262 -> B:127:0x0267). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00b8 -> B:127:0x0267). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00c2 -> B:127:0x0267). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x01a7 -> B:127:0x0267). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x01b8 -> B:93:0x01bd). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 633
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.p0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parsePricingTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {}, m = "invokeSuspend")
    public static final class q extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20471j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20472k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20473l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20474m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20475n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2) {
            super(2, dVar);
            this.f20473l = xmlPullParser;
            this.f20474m = n0Var;
            this.f20475n = n0Var2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((q) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            q qVar = new q(this.f20473l, dVar, this.f20474m, this.f20475n);
            qVar.f20472k = obj;
            return qVar;
        }

        /* JADX WARN: Type inference failed for: r0v21, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws XmlPullParserException, IOException {
            String text;
            a9.d.e();
            if (this.f20471j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            kotlinx.coroutines.p0.g((kotlinx.coroutines.o0) this.f20472k);
            if (m.m0(this.f20473l)) {
                this.f20473l.nextTag();
            }
            if (m.h0(this.f20473l)) {
                return v8.k0.f35197a;
            }
            if (!m.o0(this.f20473l)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.f20473l.getDepth();
            while (this.f20473l.getDepth() >= depth) {
                int depth2 = this.f20473l.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        m.o0(this.f20473l);
                    }
                } else if (m.o0(this.f20473l)) {
                    XmlPullParser xmlPullParser = this.f20473l;
                    this.f20474m.f29834a = m.G(xmlPullParser, "model");
                    this.f20475n.f29834a = m.G(xmlPullParser, "currency");
                } else if (m.q0(this.f20473l) && (text = this.f20473l.getText()) != null && !p9.q.z(text)) {
                    String text2 = this.f20473l.getText();
                    kotlin.jvm.internal.t.h(text2, "text");
                    p9.r.b1(text2).toString();
                } else if (m.k0(this.f20473l)) {
                    return v8.k0.f35197a;
                }
                this.f20473l.next();
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVideoClickTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {}, m = "invokeSuspend")
    public static final class q0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20476j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20477k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20478l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20479m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20480n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2) {
            super(2, dVar);
            this.f20478l = xmlPullParser;
            this.f20479m = n0Var;
            this.f20480n = n0Var2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((q0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            q0 q0Var = new q0(this.f20478l, dVar, this.f20479m, this.f20480n);
            q0Var.f20477k = obj;
            return q0Var;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws XmlPullParserException, IOException {
            String text;
            a9.d.e();
            if (this.f20476j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            kotlinx.coroutines.p0.g((kotlinx.coroutines.o0) this.f20477k);
            if (m.m0(this.f20478l)) {
                this.f20478l.nextTag();
            }
            if (m.h0(this.f20478l)) {
                return v8.k0.f35197a;
            }
            if (!m.o0(this.f20478l)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.f20478l.getDepth();
            while (this.f20478l.getDepth() >= depth) {
                int depth2 = this.f20478l.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        m.o0(this.f20478l);
                    }
                } else if (m.o0(this.f20478l)) {
                    this.f20479m.f29834a = m.G(this.f20478l, "id");
                } else if (m.q0(this.f20478l) && (text = this.f20478l.getText()) != null && !p9.q.z(text)) {
                    String text2 = this.f20478l.getText();
                    kotlin.jvm.internal.t.h(text2, "text");
                    this.f20480n.f29834a = p9.r.b1(text2).toString();
                } else if (m.k0(this.f20478l)) {
                    return v8.k0.f35197a;
                }
                this.f20478l.next();
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCompanionAdsTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {946}, m = "invokeSuspend")
    public static final class r extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20481j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20482k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20483l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20484m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ List f20485n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(XmlPullParser xmlPullParser, z8.d dVar, List list) {
            super(2, dVar);
            this.f20484m = xmlPullParser;
            this.f20485n = list;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((r) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            r rVar = new r(this.f20484m, dVar, this.f20485n);
            rVar.f20483l = obj;
            return rVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e0  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006a -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0085 -> B:32:0x008a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a1 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00bb -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d4 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 235
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.r.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseIconTag")
    public static final class r0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20486j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20487k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20488l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20489m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20490n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f20491o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Object f20492p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Object f20493q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f20494r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public /* synthetic */ Object f20495s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f20496t;

        public r0(z8.d<? super r0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20495s = obj;
            this.f20496t |= Integer.MIN_VALUE;
            return m.h(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parsePricingTag")
    public static final class s extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20497j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20498k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20499l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f20500m;

        public s(z8.d<? super s> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20499l = obj;
            this.f20500m |= Integer.MIN_VALUE;
            return m.n(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseVideoClickTag")
    public static final class s0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20501j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20502k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20503l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f20504m;

        public s0(z8.d<? super s0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20503l = obj;
            this.f20504m |= Integer.MIN_VALUE;
            return m.u(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseCompanionAdsTag")
    public static final class t extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20505j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20506k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f20507l;

        public t(z8.d<? super t> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20506k = obj;
            this.f20507l |= Integer.MIN_VALUE;
            return m.b(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseIconsTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {946}, m = "invokeSuspend")
    public static final class t0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20508j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20509k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20510l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20511m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ List f20512n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t0(XmlPullParser xmlPullParser, z8.d dVar, List list) {
            super(2, dVar);
            this.f20511m = xmlPullParser;
            this.f20512n = list;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((t0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            t0 t0Var = new t0(this.f20511m, dVar, this.f20512n);
            t0Var.f20510l = obj;
            return t0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e0  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0060 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006a -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0085 -> B:32:0x008a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a1 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00bb -> B:51:0x00d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d4 -> B:51:0x00d9). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 235
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.t0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseStaticResourceTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {}, m = "invokeSuspend")
    public static final class u extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20513j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20514k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20515l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20516m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20517n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2) {
            super(2, dVar);
            this.f20515l = xmlPullParser;
            this.f20516m = n0Var;
            this.f20517n = n0Var2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((u) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            u uVar = new u(this.f20515l, dVar, this.f20516m, this.f20517n);
            uVar.f20514k = obj;
            return uVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws XmlPullParserException, IOException {
            String text;
            a9.d.e();
            if (this.f20513j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            kotlinx.coroutines.p0.g((kotlinx.coroutines.o0) this.f20514k);
            if (m.m0(this.f20515l)) {
                this.f20515l.nextTag();
            }
            if (m.h0(this.f20515l)) {
                return v8.k0.f35197a;
            }
            if (!m.o0(this.f20515l)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.f20515l.getDepth();
            while (this.f20515l.getDepth() >= depth) {
                int depth2 = this.f20515l.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        m.o0(this.f20515l);
                    }
                } else if (m.o0(this.f20515l)) {
                    XmlPullParser xmlPullParser = this.f20515l;
                    kotlin.jvm.internal.n0 n0Var = this.f20516m;
                    String strG = m.G(xmlPullParser, "creativeType");
                    n0Var.f29834a = strG != null ? m.R(strG) : 0;
                } else if (m.q0(this.f20515l) && (text = this.f20515l.getText()) != null && !p9.q.z(text)) {
                    String text2 = this.f20515l.getText();
                    kotlin.jvm.internal.t.h(text2, "text");
                    this.f20517n.f29834a = p9.r.b1(text2).toString();
                } else if (m.k0(this.f20515l)) {
                    return v8.k0.f35197a;
                }
                this.f20515l.next();
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseVideoClicksTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {946, 947, 949}, m = "invokeSuspend")
    public static final class u0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20518j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20519k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20520l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20521m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20522n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ List f20523o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ List f20524p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, List list, List list2) {
            super(2, dVar);
            this.f20521m = xmlPullParser;
            this.f20522n = n0Var;
            this.f20523o = list;
            this.f20524p = list2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((u0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            u0 u0Var = new u0(this.f20521m, dVar, this.f20522n, this.f20523o, this.f20524p);
            u0Var.f20520l = obj;
            return u0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00f3  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0165  */
        /* JADX WARN: Type inference failed for: r5v21, types: [T, java.lang.Object] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007f -> B:83:0x015e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0089 -> B:83:0x015e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0091 -> B:83:0x015e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a5 -> B:83:0x015e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00af -> B:83:0x015e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00c7 -> B:67:0x011c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00c9 -> B:67:0x011c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d9 -> B:83:0x015e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00ea -> B:56:0x00ef). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0103 -> B:83:0x015e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0126 -> B:83:0x015e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x0140 -> B:83:0x015e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0159 -> B:83:0x015e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 368
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.u0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCompanionTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {951, 953, 956, 959, 960, 964, 969, 970}, m = "invokeSuspend")
    public static final class v extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20525j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20526k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20527l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20528m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20529n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20530o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20531p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20532q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20533r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20534s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final /* synthetic */ List f20535t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20536u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ List f20537v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ List f20538w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, kotlin.jvm.internal.n0 n0Var3, kotlin.jvm.internal.n0 n0Var4, kotlin.jvm.internal.n0 n0Var5, kotlin.jvm.internal.n0 n0Var6, List list, kotlin.jvm.internal.n0 n0Var7, List list2, List list3) {
            super(2, dVar);
            this.f20528m = xmlPullParser;
            this.f20529n = n0Var;
            this.f20530o = n0Var2;
            this.f20531p = n0Var3;
            this.f20532q = n0Var4;
            this.f20533r = n0Var5;
            this.f20534s = n0Var6;
            this.f20535t = list;
            this.f20536u = n0Var7;
            this.f20537v = list2;
            this.f20538w = list3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((v) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            v vVar = new v(this.f20528m, dVar, this.f20529n, this.f20530o, this.f20531p, this.f20532q, this.f20533r, this.f20534s, this.f20535t, this.f20536u, this.f20537v, this.f20538w);
            vVar.f20527l = obj;
            return vVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:147:0x02bc, code lost:
        
            r4.f29834a = null;
            r10.f20532q.f29834a = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.G(r2, "apiFramework");
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0213  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x02c3  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x012a  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0176  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01b9  */
        /* JADX WARN: Type inference failed for: r2v37, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v38, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v42, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v46, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v52, types: [T, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v11, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x01f8 -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x0211 -> B:76:0x0184). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0213 -> B:76:0x0184). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x0229 -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:134:0x029e -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:136:0x02b7 -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00ba -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c4 -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00cc -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00d2 -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00dd -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00f6 -> B:76:0x0184). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00f8 -> B:76:0x0184). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x010e -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0121 -> B:55:0x0126). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x013a -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x015c -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0174 -> B:76:0x0184). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0176 -> B:76:0x0184). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x018f -> B:139:0x02bc). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x01cc -> B:76:0x0184). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x01d6 -> B:139:0x02bc). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 774
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.v.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseIconsTag")
    public static final class v0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20539j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20540k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f20541l;

        public v0(z8.d<? super v0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20540k = obj;
            this.f20541l |= Integer.MIN_VALUE;
            return m.i(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseStaticResourceTag")
    public static final class w extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20542j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20543k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20544l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f20545m;

        public w(z8.d<? super w> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20544l = obj;
            this.f20545m |= Integer.MIN_VALUE;
            return m.o(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseVideoClicksTag")
    public static final class w0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f20546j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20547k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20548l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20549m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f20550n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f20551o;

        public w0(z8.d<? super w0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20550n = obj;
            this.f20551o |= Integer.MIN_VALUE;
            return m.g0(null, false, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseCompanionTag")
    public static final class x extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20552j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20553k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f20554l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Object f20555m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Object f20556n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Object f20557o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Object f20558p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Object f20559q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f20560r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Object f20561s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public /* synthetic */ Object f20562t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f20563u;

        public x(z8.d<? super x> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20562t = obj;
            this.f20563u |= Integer.MIN_VALUE;
            return m.c(null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseImpressionTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {}, m = "invokeSuspend")
    public static final class x0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20564j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20565k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20566l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20567m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20568n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2) {
            super(2, dVar);
            this.f20566l = xmlPullParser;
            this.f20567m = n0Var;
            this.f20568n = n0Var2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((x0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            x0 x0Var = new x0(this.f20566l, dVar, this.f20567m, this.f20568n);
            x0Var.f20565k = obj;
            return x0Var;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws XmlPullParserException, IOException {
            String text;
            a9.d.e();
            if (this.f20564j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            kotlinx.coroutines.p0.g((kotlinx.coroutines.o0) this.f20565k);
            if (m.m0(this.f20566l)) {
                this.f20566l.nextTag();
            }
            if (m.h0(this.f20566l)) {
                return v8.k0.f35197a;
            }
            if (!m.o0(this.f20566l)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.f20566l.getDepth();
            while (this.f20566l.getDepth() >= depth) {
                int depth2 = this.f20566l.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        m.o0(this.f20566l);
                    }
                } else if (m.o0(this.f20566l)) {
                    this.f20567m.f29834a = m.G(this.f20566l, "id");
                } else if (m.q0(this.f20566l) && (text = this.f20566l.getText()) != null && !p9.q.z(text)) {
                    String text2 = this.f20566l.getText();
                    kotlin.jvm.internal.t.h(text2, "text");
                    this.f20568n.f29834a = p9.r.b1(text2).toString();
                } else if (m.k0(this.f20566l)) {
                    return v8.k0.f35197a;
                }
                this.f20566l.next();
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseTagsTextOnly$$inlined$iterateTag$1", f = "VastParser.kt", l = {}, m = "invokeSuspend")
    public static final class y extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20569j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public /* synthetic */ Object f20570k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20571l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20572m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var) {
            super(2, dVar);
            this.f20571l = xmlPullParser;
            this.f20572m = n0Var;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((y) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            y yVar = new y(this.f20571l, dVar, this.f20572m);
            yVar.f20570k = obj;
            return yVar;
        }

        /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws XmlPullParserException, IOException {
            String text;
            a9.d.e();
            if (this.f20569j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            kotlinx.coroutines.p0.g((kotlinx.coroutines.o0) this.f20570k);
            if (m.m0(this.f20571l)) {
                this.f20571l.nextTag();
            }
            if (m.h0(this.f20571l)) {
                return v8.k0.f35197a;
            }
            if (!m.o0(this.f20571l)) {
                throw new XmlPullParserException("iterateCurrentTagEvents call is allowed only for START_TAG event");
            }
            int depth = this.f20571l.getDepth();
            while (this.f20571l.getDepth() >= depth) {
                int depth2 = this.f20571l.getDepth() - depth;
                if (depth2 != 0) {
                    if (depth2 == 1) {
                        m.o0(this.f20571l);
                    }
                } else if (m.o0(this.f20571l)) {
                    continue;
                } else if (m.q0(this.f20571l) && (text = this.f20571l.getText()) != null && !p9.q.z(text)) {
                    String text2 = this.f20571l.getText();
                    kotlin.jvm.internal.t.h(text2, "text");
                    this.f20572m.f29834a = p9.r.b1(text2).toString();
                } else if (m.k0(this.f20571l)) {
                    return v8.k0.f35197a;
                }
                this.f20571l.next();
            }
            return v8.k0.f35197a;
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseWrapperTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {949, 950, 951, 952, 953}, m = "invokeSuspend")
    public static final class y0 extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20573j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20574k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20575l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20576m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20577n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20578o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20579p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ List f20580q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ List f20581r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ List f20582s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, kotlin.jvm.internal.n0 n0Var3, List list, List list2, List list3) {
            super(2, dVar);
            this.f20576m = xmlPullParser;
            this.f20577n = n0Var;
            this.f20578o = n0Var2;
            this.f20579p = n0Var3;
            this.f20580q = list;
            this.f20581r = list2;
            this.f20582s = list3;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((y0) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            y0 y0Var = new y0(this.f20576m, dVar, this.f20577n, this.f20578o, this.f20579p, this.f20580q, this.f20581r, this.f20582s);
            y0Var.f20575l = obj;
            return y0Var;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:106:0x01c8, code lost:
        
            r9.f29834a = null;
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:102:0x01cf  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0105  */
        /* JADX WARN: Type inference failed for: r8v6, types: [T, java.lang.Boolean] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009e -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a8 -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b0 -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b6 -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00c1 -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00eb -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0115 -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x012f -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x013a -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x015b -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0169 -> B:82:0x016c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x01aa -> B:101:0x01c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x01c3 -> B:101:0x01c8). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 496
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.y0.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt$parseCreativeTag$$inlined$iterateTag$1", f = "VastParser.kt", l = {952, 956}, m = "invokeSuspend")
    public static final class z extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20583j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f20584k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20585l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ XmlPullParser f20586m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20587n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20588o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20589p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20590q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.n0 f20591r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final /* synthetic */ boolean f20592s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(XmlPullParser xmlPullParser, z8.d dVar, kotlin.jvm.internal.n0 n0Var, kotlin.jvm.internal.n0 n0Var2, kotlin.jvm.internal.n0 n0Var3, kotlin.jvm.internal.n0 n0Var4, kotlin.jvm.internal.n0 n0Var5, boolean z10) {
            super(2, dVar);
            this.f20586m = xmlPullParser;
            this.f20587n = n0Var;
            this.f20588o = n0Var2;
            this.f20589p = n0Var3;
            this.f20590q = n0Var4;
            this.f20591r = n0Var5;
            this.f20592s = z10;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((z) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            z zVar = new z(this.f20586m, dVar, this.f20587n, this.f20588o, this.f20589p, this.f20590q, this.f20591r, this.f20592s);
            zVar.f20585l = obj;
            return zVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:78:0x00f2, code lost:
        
            r7 = 0;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0162  */
        /* JADX WARN: Type inference failed for: r5v19, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v4, types: [T, java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r7v6, types: [T, java.lang.String] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0078 -> B:73:0x015b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0082 -> B:73:0x015b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008a -> B:73:0x015b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00b0 -> B:39:0x00b5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00d2 -> B:48:0x00d7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x00fd -> B:73:0x015b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x013d -> B:73:0x015b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0156 -> B:73:0x015b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            /*
                Method dump skipped, instruction units count: 365
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.z.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastParserKt", f = "VastParser.kt", l = {941}, m = "parseImpressionTag")
    public static final class z0 extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f20593j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f20594k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f20595l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f20596m;

        public z0(z8.d<? super z0> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f20595l = obj;
            this.f20596m |= Integer.MIN_VALUE;
            return m.j(null, this);
        }
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l C() {
        return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l) f20269a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object F0(org.xmlpull.v1.XmlPullParser r6, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e> r7) {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.h
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$h r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.h) r0
            int r1 = r0.f20365m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20365m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$h r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$h
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20364l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20365m
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f20363k
            kotlin.jvm.internal.n0 r6 = (kotlin.jvm.internal.n0) r6
            java.lang.Object r0 = r0.f20362j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            v8.u.b(r7)
            kotlin.jvm.internal.n0 r7 = new kotlin.jvm.internal.n0
            r7.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$f r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$f
            r5.<init>(r6, r4, r2, r7)
            r0.f20362j = r7
            r0.f20363k = r2
            r0.f20365m = r3
            java.lang.Object r6 = kotlinx.coroutines.p0.f(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.f29834a
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L6a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.e
            T r6 = r6.f29834a
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            r4.<init>(r7, r6)
        L6a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.F0(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final String G(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null || !(!p9.q.z(attributeValue))) {
            return null;
        }
        return attributeValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object G0(org.xmlpull.v1.XmlPullParser r6, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f> r7) {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.l
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$l r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.l) r0
            int r1 = r0.f20414m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20414m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$l r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$l
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20413l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20414m
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f20412k
            kotlin.jvm.internal.n0 r6 = (kotlin.jvm.internal.n0) r6
            java.lang.Object r0 = r0.f20411j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            v8.u.b(r7)
            kotlin.jvm.internal.n0 r7 = new kotlin.jvm.internal.n0
            r7.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$j r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$j
            r5.<init>(r6, r4, r2, r7)
            r0.f20411j = r7
            r0.f20412k = r2
            r0.f20414m = r3
            java.lang.Object r6 = kotlinx.coroutines.p0.f(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.f29834a
            if (r7 != 0) goto L64
            T r7 = r6.f29834a
            if (r7 != 0) goto L64
            goto L71
        L64:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f
            T r7 = r0.f29834a
            java.lang.String r7 = (java.lang.String) r7
            T r6 = r6.f29834a
            java.lang.String r6 = (java.lang.String) r6
            r4.<init>(r7, r6)
        L71:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.G0(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final SimpleDateFormat P() {
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.h.b("HH:mm:ss.SSS");
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k R(String str) {
        if (p9.q.I(str, "image/", true)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k.Image;
        }
        if (p9.r.N(str, "javascript", true)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k.JS;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object T(org.xmlpull.v1.XmlPullParser r17, boolean r18, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i> r19) {
        /*
            r0 = r19
            boolean r1 = r0 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.b0
            if (r1 == 0) goto L15
            r1 = r0
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$b0 r1 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.b0) r1
            int r2 = r1.f20300p
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f20300p = r2
            goto L1a
        L15:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$b0 r1 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$b0
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.f20299o
            java.lang.Object r2 = a9.b.e()
            int r3 = r1.f20300p
            r4 = 1
            if (r3 == 0) goto L47
            if (r3 != r4) goto L3f
            java.lang.Object r2 = r1.f20298n
            kotlin.jvm.internal.n0 r2 = (kotlin.jvm.internal.n0) r2
            java.lang.Object r3 = r1.f20297m
            kotlin.jvm.internal.n0 r3 = (kotlin.jvm.internal.n0) r3
            java.lang.Object r4 = r1.f20296l
            kotlin.jvm.internal.n0 r4 = (kotlin.jvm.internal.n0) r4
            java.lang.Object r5 = r1.f20295k
            kotlin.jvm.internal.n0 r5 = (kotlin.jvm.internal.n0) r5
            java.lang.Object r1 = r1.f20294j
            kotlin.jvm.internal.n0 r1 = (kotlin.jvm.internal.n0) r1
            v8.u.b(r0)
            goto L91
        L3f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L47:
            v8.u.b(r0)
            kotlin.jvm.internal.n0 r0 = new kotlin.jvm.internal.n0
            r0.<init>()
            kotlin.jvm.internal.n0 r3 = new kotlin.jvm.internal.n0
            r3.<init>()
            kotlin.jvm.internal.n0 r14 = new kotlin.jvm.internal.n0
            r14.<init>()
            kotlin.jvm.internal.n0 r15 = new kotlin.jvm.internal.n0
            r15.<init>()
            kotlin.jvm.internal.n0 r13 = new kotlin.jvm.internal.n0
            r13.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$z r12 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$z
            r7 = 0
            r5 = r12
            r6 = r17
            r8 = r0
            r9 = r3
            r10 = r14
            r11 = r15
            r16 = r12
            r12 = r13
            r4 = r13
            r13 = r18
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            r1.f20294j = r0
            r1.f20295k = r3
            r1.f20296l = r14
            r1.f20297m = r15
            r1.f20298n = r4
            r5 = 1
            r1.f20300p = r5
            r5 = r16
            java.lang.Object r1 = kotlinx.coroutines.p0.f(r5, r1)
            if (r1 != r2) goto L8c
            return r2
        L8c:
            r1 = r0
            r5 = r3
            r2 = r4
            r4 = r14
            r3 = r15
        L91:
            T r0 = r2.f29834a
            r11 = r0
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.j r11 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.j) r11
            if (r11 == 0) goto Lb3
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i
            T r1 = r1.f29834a
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7
            T r1 = r5.f29834a
            r8 = r1
            java.lang.Integer r8 = (java.lang.Integer) r8
            T r1 = r4.f29834a
            r9 = r1
            java.lang.String r9 = (java.lang.String) r9
            T r1 = r3.f29834a
            r10 = r1
            java.lang.String r10 = (java.lang.String) r10
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            goto Lb4
        Lb3:
            r0 = 0
        Lb4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.T(org.xmlpull.v1.XmlPullParser, boolean, z8.d):java.lang.Object");
    }

    public static final SimpleDateFormat U() {
        return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.h.b("HH:mm:ss");
    }

    public static final Long X(String str) {
        Object objB;
        Object objB2;
        try {
            t.a aVar = v8.t.f35208b;
            Date date = P().parse(str);
            objB = v8.t.b(date != null ? Long.valueOf(date.getTime()) : null);
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        if (v8.t.g(objB)) {
            objB = null;
        }
        Long l10 = (Long) objB;
        if (l10 != null) {
            return l10;
        }
        try {
            Date date2 = U().parse(str);
            objB2 = v8.t.b(date2 != null ? Long.valueOf(date2.getTime()) : null);
        } catch (Throwable th2) {
            t.a aVar3 = v8.t.f35208b;
            objB2 = v8.t.b(v8.u.a(th2));
        }
        return (Long) (v8.t.g(objB2) ? null : objB2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object Z(org.xmlpull.v1.XmlPullParser r5, boolean r6, z8.d<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.i>> r7) {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.f0
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$f0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.f0) r0
            int r1 = r0.f20345l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20345l = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$f0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$f0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20344k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20345l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f20343j
            java.util.List r5 = (java.util.List) r5
            v8.u.b(r7)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$d0 r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$d0
            r4 = 0
            r2.<init>(r5, r4, r6, r7)
            r0.f20343j = r7
            r0.f20345l = r3
            java.lang.Object r5 = kotlinx.coroutines.p0.f(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r7
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.Z(org.xmlpull.v1.XmlPullParser, boolean, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(org.xmlpull.v1.XmlPullParser r12, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b> r13) {
        /*
            boolean r0 = r13 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.p
            if (r0 == 0) goto L13
            r0 = r13
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$p r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.p) r0
            int r1 = r0.f20456n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20456n = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$p r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$p
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f20455m
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20456n
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r12 = r0.f20454l
            kotlin.jvm.internal.n0 r12 = (kotlin.jvm.internal.n0) r12
            java.lang.Object r1 = r0.f20453k
            kotlin.jvm.internal.n0 r1 = (kotlin.jvm.internal.n0) r1
            java.lang.Object r0 = r0.f20452j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r13)
            goto L6c
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            v8.u.b(r13)
            kotlin.jvm.internal.n0 r13 = new kotlin.jvm.internal.n0
            r13.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            kotlin.jvm.internal.n0 r10 = new kotlin.jvm.internal.n0
            r10.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$n r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$n
            r6 = 0
            r4 = r11
            r5 = r12
            r7 = r13
            r8 = r2
            r9 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f20452j = r13
            r0.f20453k = r2
            r0.f20454l = r10
            r0.f20456n = r3
            java.lang.Object r12 = kotlinx.coroutines.p0.f(r11, r0)
            if (r12 != r1) goto L69
            return r1
        L69:
            r0 = r13
            r1 = r2
            r12 = r10
        L6c:
            T r12 = r12.f29834a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.c r12 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.c) r12
            if (r12 == 0) goto L80
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b r13 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b
            T r0 = r0.f29834a
            java.lang.String r0 = (java.lang.String) r0
            T r1 = r1.f29834a
            java.lang.Integer r1 = (java.lang.Integer) r1
            r13.<init>(r0, r1, r12)
            goto L81
        L80:
            r13 = 0
        L81:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.a(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t a0(String str) {
        Long lX = X(str);
        if (lX != null) {
            return new t.b(lX.longValue());
        }
        Integer numE0 = e0(str);
        if (numE0 != null) {
            return new t.a(numE0.intValue());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(org.xmlpull.v1.XmlPullParser r5, z8.d<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g>> r6) {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.t
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$t r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.t) r0
            int r1 = r0.f20507l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20507l = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$t r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$t
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20506k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20507l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f20505j
            java.util.List r5 = (java.util.List) r5
            v8.u.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$r r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$r
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f20505j = r6
            r0.f20507l = r3
            java.lang.Object r5 = kotlinx.coroutines.p0.f(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.b(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(org.xmlpull.v1.XmlPullParser r25, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.g> r26) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.c(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final Object d(XmlPullParser xmlPullParser, z8.d<? super String> dVar) {
        return p(xmlPullParser, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d0(org.xmlpull.v1.XmlPullParser r19, boolean r20, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r> r21) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.d0(org.xmlpull.v1.XmlPullParser, boolean, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(org.xmlpull.v1.XmlPullParser r4, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l> r5) {
        /*
            boolean r0 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.h0
            if (r0 == 0) goto L13
            r0 = r5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$h0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.h0) r0
            int r1 = r0.f20367k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20367k = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$h0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$h0
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20366j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20367k
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            v8.u.b(r5)
            r0.f20367k = r3
            java.lang.Object r5 = p(r4, r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L47
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.l
            r4.<init>(r5)
            goto L48
        L47:
            r4 = 0
        L48:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.e(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final Integer e0(String str) {
        Object objB;
        Integer numValueOf;
        int iIntValue;
        try {
            t.a aVar = v8.t.f35208b;
            Number number = f20270b.parse(str);
            if (number == null || (iIntValue = (numValueOf = Integer.valueOf((int) (number.floatValue() * 100))).intValue()) < 0 || iIntValue >= 101) {
                numValueOf = null;
            }
            objB = v8.t.b(numValueOf);
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        return (Integer) (v8.t.g(objB) ? null : objB);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(org.xmlpull.v1.XmlPullParser r4, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m> r5) {
        /*
            boolean r0 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.j0
            if (r0 == 0) goto L13
            r0 = r5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$j0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.j0) r0
            int r1 = r0.f20394k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20394k = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$j0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$j0
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f20393j
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20394k
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            v8.u.b(r5)
            r0.f20394k = r3
            java.lang.Object r5 = p(r4, r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L47
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.m
            r4.<init>(r5)
            goto L48
        L47:
            r4 = 0
        L48:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.f(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(org.xmlpull.v1.XmlPullParser r6, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o> r7) {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.n0
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$n0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.n0) r0
            int r1 = r0.f20443m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20443m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$n0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$n0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20442l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20443m
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f20441k
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r0 = r0.f20440j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            v8.u.b(r7)
            kotlin.jvm.internal.n0 r7 = new kotlin.jvm.internal.n0
            r7.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$l0 r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$l0
            r5.<init>(r6, r4, r7, r2)
            r0.f20440j = r7
            r0.f20441k = r2
            r0.f20443m = r3
            java.lang.Object r6 = kotlinx.coroutines.p0.f(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.f29834a
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L66
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.o
            r4.<init>(r7, r6)
        L66:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.g(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g0(org.xmlpull.v1.XmlPullParser r12, boolean r13, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a> r14) {
        /*
            boolean r0 = r14 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.w0
            if (r0 == 0) goto L13
            r0 = r14
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$w0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.w0) r0
            int r1 = r0.f20551o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20551o = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$w0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$w0
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.f20550n
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20551o
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            boolean r13 = r0.f20546j
            java.lang.Object r12 = r0.f20549m
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r1 = r0.f20548l
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r0 = r0.f20547k
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r14)
            goto L70
        L37:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3f:
            v8.u.b(r14)
            kotlin.jvm.internal.n0 r14 = new kotlin.jvm.internal.n0
            r14.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$u0 r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$u0
            r6 = 0
            r4 = r11
            r5 = r12
            r7 = r14
            r8 = r2
            r9 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f20547k = r14
            r0.f20548l = r2
            r0.f20549m = r10
            r0.f20546j = r13
            r0.f20551o = r3
            java.lang.Object r12 = kotlinx.coroutines.p0.f(r11, r0)
            if (r12 != r1) goto L6d
            return r1
        L6d:
            r0 = r14
            r1 = r2
            r12 = r10
        L70:
            if (r13 == 0) goto L78
            T r13 = r0.f29834a
            if (r13 != 0) goto L78
            r12 = 0
            goto L82
        L78:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a r13 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a
            T r14 = r0.f29834a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b0 r14 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b0) r14
            r13.<init>(r14, r1, r12)
            r12 = r13
        L82:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.g0(org.xmlpull.v1.XmlPullParser, boolean, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(org.xmlpull.v1.XmlPullParser r24, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n> r25) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.h(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final boolean h0(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(org.xmlpull.v1.XmlPullParser r5, z8.d<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.n>> r6) {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.v0
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$v0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.v0) r0
            int r1 = r0.f20541l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20541l = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$v0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$v0
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20540k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20541l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f20539j
            java.util.List r5 = (java.util.List) r5
            v8.u.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$t0 r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$t0
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f20539j = r6
            r0.f20541l = r3
            java.lang.Object r5 = kotlinx.coroutines.p0.f(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.i(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x i0(String str) {
        switch (str.hashCode()) {
            case -1638835128:
                if (str.equals("midpoint")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Midpoint;
                }
                return null;
            case -1337830390:
                if (str.equals("thirdQuartile")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.ThirdQuartile;
                }
                return null;
            case -1001078227:
                if (str.equals("progress")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Progress;
                }
                return null;
            case -934426579:
                if (str.equals("resume")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Resume;
                }
                return null;
            case -934318917:
                if (str.equals("rewind")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Rewind;
                }
                return null;
            case -840405966:
                if (str.equals("unmute")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.UnMute;
                }
                return null;
            case -599445191:
                if (str.equals("complete")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Complete;
                }
                return null;
            case -37683395:
                if (str.equals("closeLinear")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.CloseLinear;
                }
                return null;
            case 3363353:
                if (str.equals("mute")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Mute;
                }
                return null;
            case 3532159:
                if (str.equals("skip")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Skip;
                }
                return null;
            case 106440182:
                if (str.equals("pause")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Pause;
                }
                return null;
            case 109757538:
                if (str.equals(TtmlNode.START)) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Start;
                }
                return null;
            case 560220243:
                if (str.equals("firstQuartile")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.FirstQuartile;
                }
                return null;
            case 1778167540:
                if (str.equals("creativeView")) {
                    return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.CreativeView;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object j(org.xmlpull.v1.XmlPullParser r6, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p> r7) {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.z0
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$z0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.z0) r0
            int r1 = r0.f20596m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20596m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$z0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$z0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20595l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20596m
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f20594k
            kotlin.jvm.internal.n0 r6 = (kotlin.jvm.internal.n0) r6
            java.lang.Object r0 = r0.f20593j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            v8.u.b(r7)
            kotlin.jvm.internal.n0 r7 = new kotlin.jvm.internal.n0
            r7.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$x0 r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$x0
            r5.<init>(r6, r4, r7, r2)
            r0.f20593j = r7
            r0.f20594k = r2
            r0.f20596m = r3
            java.lang.Object r6 = kotlinx.coroutines.p0.f(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r6 = r6.f29834a
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L6a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.p
            T r7 = r0.f29834a
            java.lang.String r7 = (java.lang.String) r7
            r4.<init>(r7, r6)
        L6a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.j(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object k(org.xmlpull.v1.XmlPullParser r20, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q> r21) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.k(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final boolean k0(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(org.xmlpull.v1.XmlPullParser r31, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s> r32) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.l(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m(org.xmlpull.v1.XmlPullParser r5, z8.d<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.s>> r6) {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.o
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$o r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.o) r0
            int r1 = r0.f20446l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20446l = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$o r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$o
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20445k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20446l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f20444j
            java.util.List r5 = (java.util.List) r5
            v8.u.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$m r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$m
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f20444j = r6
            r0.f20446l = r3
            java.lang.Object r5 = kotlinx.coroutines.p0.f(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.m(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final boolean m0(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object n(org.xmlpull.v1.XmlPullParser r6, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u> r7) {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.s
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$s r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.s) r0
            int r1 = r0.f20500m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20500m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$s r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$s
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20499l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20500m
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f20498k
            kotlin.jvm.internal.n0 r6 = (kotlin.jvm.internal.n0) r6
            java.lang.Object r0 = r0.f20497j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            v8.u.b(r7)
            kotlin.jvm.internal.n0 r7 = new kotlin.jvm.internal.n0
            r7.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$q r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$q
            r5.<init>(r6, r4, r7, r2)
            r0.f20497j = r7
            r0.f20498k = r2
            r0.f20500m = r3
            java.lang.Object r6 = kotlinx.coroutines.p0.f(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.f29834a
            if (r7 != 0) goto L64
            T r7 = r6.f29834a
            if (r7 != 0) goto L64
            goto L71
        L64:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.u
            T r7 = r0.f29834a
            java.lang.String r7 = (java.lang.String) r7
            T r6 = r6.f29834a
            java.lang.String r6 = (java.lang.String) r6
            r4.<init>(r7, r6)
        L71:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.n(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object o(org.xmlpull.v1.XmlPullParser r6, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v> r7) {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.w
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$w r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.w) r0
            int r1 = r0.f20545m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20545m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$w r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$w
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20544l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20545m
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f20543k
            kotlin.jvm.internal.n0 r6 = (kotlin.jvm.internal.n0) r6
            java.lang.Object r0 = r0.f20542j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            v8.u.b(r7)
            kotlin.jvm.internal.n0 r7 = new kotlin.jvm.internal.n0
            r7.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$u r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$u
            r5.<init>(r6, r4, r2, r7)
            r0.f20542j = r7
            r0.f20543k = r2
            r0.f20545m = r3
            java.lang.Object r6 = kotlinx.coroutines.p0.f(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r7 = r0.f29834a
            if (r7 == 0) goto L77
            T r7 = r6.f29834a
            if (r7 != 0) goto L64
            goto L77
        L64:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.v
            T r7 = r0.f29834a
            kotlin.jvm.internal.t.f(r7)
            java.lang.String r7 = (java.lang.String) r7
            T r6 = r6.f29834a
            kotlin.jvm.internal.t.f(r6)
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k) r6
            r4.<init>(r7, r6)
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.o(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final boolean o0(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object p(org.xmlpull.v1.XmlPullParser r5, z8.d<? super java.lang.String> r6) {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.a0
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$a0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.a0) r0
            int r1 = r0.f20285l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20285l = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$a0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$a0
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20284k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20285l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f20283j
            kotlin.jvm.internal.n0 r5 = (kotlin.jvm.internal.n0) r5
            v8.u.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            kotlin.jvm.internal.n0 r6 = new kotlin.jvm.internal.n0
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$y r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$y
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f20283j = r6
            r0.f20285l = r3
            java.lang.Object r5 = kotlinx.coroutines.p0.f(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            T r5 = r5.f29834a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.p(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(org.xmlpull.v1.XmlPullParser r5, z8.d<? super java.util.List<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w>> r6) {
        /*
            boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.e0
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$e0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.e0) r0
            int r1 = r0.f20337l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20337l = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$e0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$e0
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f20336k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20337l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f20335j
            java.util.List r5 = (java.util.List) r5
            v8.u.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$c0 r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$c0
            r4 = 0
            r2.<init>(r5, r4, r6)
            r0.f20335j = r6
            r0.f20337l = r3
            java.lang.Object r5 = kotlinx.coroutines.p0.f(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r5 = r6
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.q(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final boolean q0(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object r(org.xmlpull.v1.XmlPullParser r12, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w> r13) {
        /*
            boolean r0 = r13 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.i0
            if (r0 == 0) goto L13
            r0 = r13
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$i0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.i0) r0
            int r1 = r0.f20387n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20387n = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$i0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$i0
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f20386m
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20387n
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r12 = r0.f20385l
            kotlin.jvm.internal.n0 r12 = (kotlin.jvm.internal.n0) r12
            java.lang.Object r1 = r0.f20384k
            kotlin.jvm.internal.n0 r1 = (kotlin.jvm.internal.n0) r1
            java.lang.Object r0 = r0.f20383j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r13)
            goto L6c
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            v8.u.b(r13)
            kotlin.jvm.internal.n0 r13 = new kotlin.jvm.internal.n0
            r13.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            kotlin.jvm.internal.n0 r10 = new kotlin.jvm.internal.n0
            r10.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$g0 r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$g0
            r6 = 0
            r4 = r11
            r5 = r12
            r7 = r13
            r8 = r10
            r9 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f20383j = r13
            r0.f20384k = r2
            r0.f20385l = r10
            r0.f20387n = r3
            java.lang.Object r12 = kotlinx.coroutines.p0.f(r11, r0)
            if (r12 != r1) goto L69
            return r1
        L69:
            r0 = r13
            r1 = r2
            r12 = r10
        L6c:
            T r13 = r0.f29834a
            if (r13 == 0) goto L95
            T r2 = r1.f29834a
            if (r2 == 0) goto L95
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x r2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x.Progress
            if (r13 != r2) goto L7d
            T r13 = r12.f29834a
            if (r13 != 0) goto L7d
            goto L95
        L7d:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w r13 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.w
            T r0 = r0.f29834a
            kotlin.jvm.internal.t.f(r0)
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x) r0
            T r1 = r1.f29834a
            kotlin.jvm.internal.t.f(r1)
            java.lang.String r1 = (java.lang.String) r1
            T r12 = r12.f29834a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t r12 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t) r12
            r13.<init>(r0, r1, r12)
            goto L96
        L95:
            r13 = 0
        L96:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.r(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final Integer r0(XmlPullParser xmlPullParser) {
        String strG = G(xmlPullParser, "sequence");
        if (strG == null) {
            return null;
        }
        Integer numL = p9.p.l(strG);
        return Integer.valueOf(numL != null ? numL.intValue() : RoomDatabase.MAX_BIND_PARAMETER_CNT);
    }

    public static final Object s(XmlPullParser xmlPullParser, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y> dVar) {
        return kotlinx.coroutines.i.g(com.moloco.sdk.internal.scheduling.c.a().getIo(), new k0(xmlPullParser, null), dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object t(org.xmlpull.v1.XmlPullParser r12, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y> r13) {
        /*
            boolean r0 = r13 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.o0
            if (r0 == 0) goto L13
            r0 = r13
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$o0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.o0) r0
            int r1 = r0.f20451n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20451n = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$o0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$o0
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f20450m
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20451n
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r12 = r0.f20449l
            kotlin.jvm.internal.n0 r12 = (kotlin.jvm.internal.n0) r12
            java.lang.Object r1 = r0.f20448k
            kotlin.jvm.internal.n0 r1 = (kotlin.jvm.internal.n0) r1
            java.lang.Object r0 = r0.f20447j
            java.util.List r0 = (java.util.List) r0
            v8.u.b(r13)
            goto L6c
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            v8.u.b(r13)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            kotlin.jvm.internal.n0 r10 = new kotlin.jvm.internal.n0
            r10.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$m0 r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$m0
            r6 = 0
            r4 = r11
            r5 = r12
            r7 = r2
            r8 = r10
            r9 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f20447j = r13
            r0.f20448k = r2
            r0.f20449l = r10
            r0.f20451n = r3
            java.lang.Object r12 = kotlinx.coroutines.p0.f(r11, r0)
            if (r12 != r1) goto L69
            return r1
        L69:
            r0 = r13
            r1 = r2
            r12 = r10
        L6c:
            boolean r13 = r0.isEmpty()
            if (r13 == 0) goto L78
            T r13 = r12.f29834a
            if (r13 != 0) goto L78
            r12 = 0
            goto L86
        L78:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y r13 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y
            T r12 = r12.f29834a
            java.lang.String r12 = (java.lang.String) r12
            T r1 = r1.f29834a
            java.lang.String r1 = (java.lang.String) r1
            r13.<init>(r0, r12, r1)
            r12 = r13
        L86:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.t(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t t0(XmlPullParser xmlPullParser) {
        String strG = G(xmlPullParser, "skipoffset");
        if (strG != null) {
            return a0(strG);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object u(org.xmlpull.v1.XmlPullParser r6, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b0> r7) {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.s0
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$s0 r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.s0) r0
            int r1 = r0.f20504m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20504m = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$s0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$s0
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20503l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f20504m
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.f20502k
            kotlin.jvm.internal.n0 r6 = (kotlin.jvm.internal.n0) r6
            java.lang.Object r0 = r0.f20501j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r7)
            goto L5b
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            v8.u.b(r7)
            kotlin.jvm.internal.n0 r7 = new kotlin.jvm.internal.n0
            r7.<init>()
            kotlin.jvm.internal.n0 r2 = new kotlin.jvm.internal.n0
            r2.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$q0 r5 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$q0
            r5.<init>(r6, r4, r7, r2)
            r0.f20501j = r7
            r0.f20502k = r2
            r0.f20504m = r3
            java.lang.Object r6 = kotlinx.coroutines.p0.f(r5, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            r0 = r7
            r6 = r2
        L5b:
            T r6 = r6.f29834a
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L6a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b0 r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b0
            T r7 = r0.f29834a
            java.lang.String r7 = (java.lang.String) r7
            r4.<init>(r7, r6)
        L6a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.u(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object v(org.xmlpull.v1.XmlPullParser r17, z8.d<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d> r18) {
        /*
            r0 = r18
            boolean r1 = r0 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.b
            if (r1 == 0) goto L15
            r1 = r0
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$b r1 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.b) r1
            int r2 = r1.f20293q
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f20293q = r2
            goto L1a
        L15:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$b r1 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$b
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.f20292p
            java.lang.Object r2 = a9.b.e()
            int r3 = r1.f20293q
            r4 = 1
            if (r3 == 0) goto L4e
            if (r3 != r4) goto L46
            java.lang.Object r2 = r1.f20291o
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r1.f20290n
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r1.f20289m
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r1.f20288l
            kotlin.jvm.internal.n0 r5 = (kotlin.jvm.internal.n0) r5
            java.lang.Object r6 = r1.f20287k
            kotlin.jvm.internal.n0 r6 = (kotlin.jvm.internal.n0) r6
            java.lang.Object r1 = r1.f20286j
            kotlin.jvm.internal.n0 r1 = (kotlin.jvm.internal.n0) r1
            v8.u.b(r0)
            r8 = r2
            r7 = r3
            r15 = r4
            goto La3
        L46:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4e:
            v8.u.b(r0)
            kotlin.jvm.internal.n0 r0 = new kotlin.jvm.internal.n0
            r0.<init>()
            kotlin.jvm.internal.n0 r3 = new kotlin.jvm.internal.n0
            r3.<init>()
            kotlin.jvm.internal.n0 r14 = new kotlin.jvm.internal.n0
            r14.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$y0 r11 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m$y0
            r7 = 0
            r5 = r11
            r6 = r17
            r8 = r3
            r9 = r0
            r10 = r14
            r16 = r11
            r11 = r15
            r17 = r12
            r12 = r13
            r4 = r13
            r13 = r17
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            r1.f20286j = r0
            r1.f20287k = r3
            r1.f20288l = r14
            r1.f20289m = r15
            r1.f20290n = r4
            r5 = r17
            r1.f20291o = r5
            r6 = 1
            r1.f20293q = r6
            r6 = r16
            java.lang.Object r1 = kotlinx.coroutines.p0.f(r6, r1)
            if (r1 != r2) goto L9e
            return r2
        L9e:
            r1 = r0
            r6 = r3
            r7 = r4
            r8 = r5
            r5 = r14
        La3:
            T r0 = r1.f29834a
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lbc
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.d
            T r1 = r6.f29834a
            r4 = r1
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            T r1 = r5.f29834a
            r5 = r1
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.f) r5
            r2 = r0
            r6 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto Lbd
        Lbc:
            r0 = 0
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.m.v(org.xmlpull.v1.XmlPullParser, z8.d):java.lang.Object");
    }

    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k w() {
        return C();
    }
}
