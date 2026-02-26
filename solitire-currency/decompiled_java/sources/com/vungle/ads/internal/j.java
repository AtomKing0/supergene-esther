package com.vungle.ads.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.util.x;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ClickCoordinateTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j {

    @NotNull
    private static final String TAG = "ClickCoordinateTracker";

    @NotNull
    private final com.vungle.ads.internal.model.b advertisement;

    @NotNull
    private final Context context;

    @NotNull
    private final a currentClick;

    @NotNull
    private final Executor executor;

    @NotNull
    private final v8.l executors$delegate;

    @NotNull
    private final v8.l vungleApiClient$delegate;

    @NotNull
    public static final b Companion = new b(null);
    private static final String MACRO_REQ_WIDTH = Pattern.quote("{{{req_width}}}");
    private static final String MACRO_REQ_HEIGHT = Pattern.quote("{{{req_height}}}");
    private static final String MACRO_WIDTH = Pattern.quote("{{{width}}}");
    private static final String MACRO_HEIGHT = Pattern.quote("{{{height}}}");
    private static final String MACRO_DOWN_X = Pattern.quote("{{{down_x}}}");
    private static final String MACRO_DOWN_Y = Pattern.quote("{{{down_y}}}");
    private static final String MACRO_UP_X = Pattern.quote("{{{up_x}}}");
    private static final String MACRO_UP_Y = Pattern.quote("{{{up_y}}}");

    /* JADX INFO: compiled from: ClickCoordinateTracker.kt */
    public static final class a {

        @NotNull
        private c downCoordinate;

        @NotNull
        private c upCoordinate;

        public a(@NotNull c downCoordinate, @NotNull c upCoordinate) {
            kotlin.jvm.internal.t.i(downCoordinate, "downCoordinate");
            kotlin.jvm.internal.t.i(upCoordinate, "upCoordinate");
            this.downCoordinate = downCoordinate;
            this.upCoordinate = upCoordinate;
        }

        public static /* synthetic */ a copy$default(a aVar, c cVar, c cVar2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                cVar = aVar.downCoordinate;
            }
            if ((i10 & 2) != 0) {
                cVar2 = aVar.upCoordinate;
            }
            return aVar.copy(cVar, cVar2);
        }

        @NotNull
        public final c component1() {
            return this.downCoordinate;
        }

        @NotNull
        public final c component2() {
            return this.upCoordinate;
        }

        @NotNull
        public final a copy(@NotNull c downCoordinate, @NotNull c upCoordinate) {
            kotlin.jvm.internal.t.i(downCoordinate, "downCoordinate");
            kotlin.jvm.internal.t.i(upCoordinate, "upCoordinate");
            return new a(downCoordinate, upCoordinate);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.d(this.downCoordinate, aVar.downCoordinate) && kotlin.jvm.internal.t.d(this.upCoordinate, aVar.upCoordinate);
        }

        @NotNull
        public final c getDownCoordinate() {
            return this.downCoordinate;
        }

        @NotNull
        public final c getUpCoordinate() {
            return this.upCoordinate;
        }

        public int hashCode() {
            return (this.downCoordinate.hashCode() * 31) + this.upCoordinate.hashCode();
        }

        public final boolean ready() {
            return (this.downCoordinate.getX() == Integer.MIN_VALUE || this.downCoordinate.getY() == Integer.MIN_VALUE || this.upCoordinate.getX() == Integer.MIN_VALUE || this.upCoordinate.getY() == Integer.MIN_VALUE) ? false : true;
        }

        public final void setDownCoordinate(@NotNull c cVar) {
            kotlin.jvm.internal.t.i(cVar, "<set-?>");
            this.downCoordinate = cVar;
        }

        public final void setUpCoordinate(@NotNull c cVar) {
            kotlin.jvm.internal.t.i(cVar, "<set-?>");
            this.upCoordinate = cVar;
        }

        @NotNull
        public String toString() {
            return "ClickCoordinate(downCoordinate=" + this.downCoordinate + ", upCoordinate=" + this.upCoordinate + ')';
        }
    }

    /* JADX INFO: compiled from: ClickCoordinateTracker.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ClickCoordinateTracker.kt */
    public static final class c {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final int f24322x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final int f24323y;

        public c(int i10, int i11) {
            this.f24322x = i10;
            this.f24323y = i11;
        }

        public static /* synthetic */ c copy$default(c cVar, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = cVar.f24322x;
            }
            if ((i12 & 2) != 0) {
                i11 = cVar.f24323y;
            }
            return cVar.copy(i10, i11);
        }

        public final int component1() {
            return this.f24322x;
        }

        public final int component2() {
            return this.f24323y;
        }

        @NotNull
        public final c copy(int i10, int i11) {
            return new c(i10, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f24322x == cVar.f24322x && this.f24323y == cVar.f24323y;
        }

        public final int getX() {
            return this.f24322x;
        }

        public final int getY() {
            return this.f24323y;
        }

        public int hashCode() {
            return (this.f24322x * 31) + this.f24323y;
        }

        @NotNull
        public String toString() {
            return "Coordinate(x=" + this.f24322x + ", y=" + this.f24323y + ')';
        }
    }

    /* JADX INFO: compiled from: ClickCoordinateTracker.kt */
    public static final class d {

        @NotNull
        private final Context context;

        @NotNull
        private final DisplayMetrics dm;

        public d(@NotNull Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            this.context = context;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.dm = displayMetrics;
            Object systemService = context.getSystemService("window");
            kotlin.jvm.internal.t.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        }

        public static /* synthetic */ d copy$default(d dVar, Context context, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                context = dVar.context;
            }
            return dVar.copy(context);
        }

        @NotNull
        public final Context component1() {
            return this.context;
        }

        @NotNull
        public final d copy(@NotNull Context context) {
            kotlin.jvm.internal.t.i(context, "context");
            return new d(context);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && kotlin.jvm.internal.t.d(this.context, ((d) obj).context);
        }

        @NotNull
        public final Context getContext() {
            return this.context;
        }

        public final int getDeviceHeight() {
            return this.dm.heightPixels;
        }

        public final int getDeviceWidth() {
            return this.dm.widthPixels;
        }

        public int hashCode() {
            return this.context.hashCode();
        }

        @NotNull
        public String toString() {
            return "DeviceScreenInfo(context=" + this.context + ')';
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class e extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.util.q> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.q, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.util.q invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.util.q.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class f extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.signals.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.signals.b.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class g extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.network.i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.i, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.network.i invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.network.i.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class h extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.a, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.a invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.a.class);
        }
    }

    public j(@NotNull Context context, @NotNull com.vungle.ads.internal.model.b advertisement, @NotNull Executor executor) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(advertisement, "advertisement");
        kotlin.jvm.internal.t.i(executor, "executor");
        this.context = context;
        this.advertisement = advertisement;
        this.executor = executor;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.p pVar = v8.p.f35201a;
        this.vungleApiClient$delegate = v8.n.b(pVar, new g(context));
        this.executors$delegate = v8.n.b(pVar, new h(context));
        this.currentClick = new a(new c(Integer.MIN_VALUE, Integer.MIN_VALUE), new c(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    private final int getDeviceHeight() {
        return new d(this.context).getDeviceHeight();
    }

    private final int getDeviceWidth() {
        return new d(this.context).getDeviceWidth();
    }

    private final com.vungle.ads.internal.executor.a getExecutors() {
        return (com.vungle.ads.internal.executor.a) this.executors$delegate.getValue();
    }

    private final int getRequestedHeight() {
        int iAdHeight = this.advertisement.adHeight();
        return iAdHeight == 0 ? getDeviceHeight() : x.INSTANCE.dpToPixels(this.context, iAdHeight);
    }

    private final int getRequestedWidth() {
        int iAdWidth = this.advertisement.adWidth();
        return iAdWidth == 0 ? getDeviceWidth() : x.INSTANCE.dpToPixels(this.context, iAdWidth);
    }

    private final com.vungle.ads.internal.network.i getVungleApiClient() {
        return (com.vungle.ads.internal.network.i) this.vungleApiClient$delegate.getValue();
    }

    private final void sendClickCoordinates() {
        List<String> tpatUrls$default = com.vungle.ads.internal.model.b.getTpatUrls$default(this.advertisement, com.vungle.ads.internal.model.b.TPAT_CLICK_COORDINATES_URLS, null, null, 6, null);
        List list = tpatUrls$default;
        if (list == null || list.isEmpty()) {
            com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(129, "Empty urls for tpat: video.clickCoordinates", this.advertisement.placementId(), this.advertisement.getCreativeId(), this.advertisement.eventId());
            return;
        }
        int requestedWidth = getRequestedWidth();
        int requestedHeight = getRequestedHeight();
        int requestedWidth2 = getRequestedWidth();
        int requestedHeight2 = getRequestedHeight();
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Context context = this.context;
        v8.p pVar = v8.p.f35201a;
        com.vungle.ads.internal.network.g gVar = new com.vungle.ads.internal.network.g(getVungleApiClient(), this.advertisement.placementId(), this.advertisement.getCreativeId(), this.advertisement.eventId(), getExecutors().getIoExecutor(), m4048sendClickCoordinates$lambda0(v8.n.b(pVar, new e(context))), m4049sendClickCoordinates$lambda1(v8.n.b(pVar, new f(this.context))));
        for (String str : tpatUrls$default) {
            String MACRO_REQ_WIDTH2 = MACRO_REQ_WIDTH;
            kotlin.jvm.internal.t.h(MACRO_REQ_WIDTH2, "MACRO_REQ_WIDTH");
            String strB = new p9.f(MACRO_REQ_WIDTH2).b(str, String.valueOf(requestedWidth));
            String MACRO_REQ_HEIGHT2 = MACRO_REQ_HEIGHT;
            kotlin.jvm.internal.t.h(MACRO_REQ_HEIGHT2, "MACRO_REQ_HEIGHT");
            String strB2 = new p9.f(MACRO_REQ_HEIGHT2).b(strB, String.valueOf(requestedHeight));
            String MACRO_WIDTH2 = MACRO_WIDTH;
            kotlin.jvm.internal.t.h(MACRO_WIDTH2, "MACRO_WIDTH");
            String strB3 = new p9.f(MACRO_WIDTH2).b(strB2, String.valueOf(requestedWidth2));
            String MACRO_HEIGHT2 = MACRO_HEIGHT;
            kotlin.jvm.internal.t.h(MACRO_HEIGHT2, "MACRO_HEIGHT");
            String strB4 = new p9.f(MACRO_HEIGHT2).b(strB3, String.valueOf(requestedHeight2));
            String MACRO_DOWN_X2 = MACRO_DOWN_X;
            kotlin.jvm.internal.t.h(MACRO_DOWN_X2, "MACRO_DOWN_X");
            String strB5 = new p9.f(MACRO_DOWN_X2).b(strB4, String.valueOf(this.currentClick.getDownCoordinate().getX()));
            String MACRO_DOWN_Y2 = MACRO_DOWN_Y;
            kotlin.jvm.internal.t.h(MACRO_DOWN_Y2, "MACRO_DOWN_Y");
            String strB6 = new p9.f(MACRO_DOWN_Y2).b(strB5, String.valueOf(this.currentClick.getDownCoordinate().getY()));
            String MACRO_UP_X2 = MACRO_UP_X;
            kotlin.jvm.internal.t.h(MACRO_UP_X2, "MACRO_UP_X");
            String strB7 = new p9.f(MACRO_UP_X2).b(strB6, String.valueOf(this.currentClick.getUpCoordinate().getX()));
            String MACRO_UP_Y2 = MACRO_UP_Y;
            kotlin.jvm.internal.t.h(MACRO_UP_Y2, "MACRO_UP_Y");
            gVar.sendTpat(new p9.f(MACRO_UP_Y2).b(strB7, String.valueOf(this.currentClick.getUpCoordinate().getY())), this.executor);
        }
    }

    /* JADX INFO: renamed from: sendClickCoordinates$lambda-0, reason: not valid java name */
    private static final com.vungle.ads.internal.util.q m4048sendClickCoordinates$lambda0(v8.l<com.vungle.ads.internal.util.q> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: sendClickCoordinates$lambda-1, reason: not valid java name */
    private static final com.vungle.ads.internal.signals.b m4049sendClickCoordinates$lambda1(v8.l<com.vungle.ads.internal.signals.b> lVar) {
        return lVar.getValue();
    }

    @NotNull
    public final a getCurrentClick$vungle_ads_release() {
        return this.currentClick;
    }

    public final void trackCoordinate(@NotNull MotionEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        if (this.advertisement.isClickCoordinatesTrackingEnabled()) {
            int action = event.getAction();
            if (action == 0) {
                this.currentClick.setDownCoordinate(new c((int) event.getX(), (int) event.getY()));
            } else {
                if (action != 1) {
                    return;
                }
                this.currentClick.setUpCoordinate(new c((int) event.getX(), (int) event.getY()));
                if (this.currentClick.ready()) {
                    sendClickCoordinates();
                }
            }
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getCurrentClick$vungle_ads_release$annotations() {
    }
}
