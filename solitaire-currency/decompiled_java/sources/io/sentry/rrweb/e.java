package io.sentry.rrweb;

import io.sentry.h2;
import io.sentry.l3;
import io.sentry.m3;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.rrweb.b;
import io.sentry.rrweb.d;
import io.sentry.w0;
import io.sentry.x1;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RRWebInteractionEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends d implements h2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private b f28171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f28172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f28173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f28174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f28175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f28176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private Map<String, Object> f28178k;

    /* JADX INFO: compiled from: RRWebInteractionEvent.java */
    public static final class a implements x1<e> {
        private void b(@NotNull e eVar, @NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            String strC;
            d.a aVar = new d.a();
            l3Var.h();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                strC = l3Var.C();
                strC.hashCode();
                switch (strC) {
                    case "x":
                        eVar.f28173f = l3Var.nextFloat();
                        break;
                    case "y":
                        eVar.f28174g = l3Var.nextFloat();
                        break;
                    case "id":
                        eVar.f28172e = l3Var.nextInt();
                        break;
                    case "type":
                        eVar.f28171d = (b) l3Var.M(w0Var, new b.a());
                        break;
                    case "pointerType":
                        eVar.f28175h = l3Var.nextInt();
                        break;
                    case "pointerId":
                        eVar.f28176i = l3Var.nextInt();
                        break;
                    default:
                        if (!aVar.a(eVar, strC, l3Var, w0Var)) {
                            if (map == null) {
                                map = new HashMap();
                            }
                            l3Var.r0(w0Var, map, strC);
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
            eVar.n(map);
            l3Var.k();
        }

        @Override // io.sentry.x1
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
            l3Var.h();
            e eVar = new e();
            b.a aVar = new b.a();
            HashMap map = null;
            while (l3Var.peek() == io.sentry.vendor.gson.stream.b.NAME) {
                String strC = l3Var.C();
                strC.hashCode();
                if (strC.equals("data")) {
                    b(eVar, l3Var, w0Var);
                } else if (!aVar.a(eVar, strC, l3Var, w0Var)) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    l3Var.r0(w0Var, map, strC);
                }
            }
            eVar.o(map);
            l3Var.k();
            return eVar;
        }
    }

    /* JADX INFO: compiled from: RRWebInteractionEvent.java */
    public enum b implements h2 {
        MouseUp,
        MouseDown,
        Click,
        ContextMenu,
        DblClick,
        Focus,
        Blur,
        TouchStart,
        TouchMove_Departed,
        TouchEnd,
        TouchCancel;

        /* JADX INFO: compiled from: RRWebInteractionEvent.java */
        public static final class a implements x1<b> {
            @Override // io.sentry.x1
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public b deserialize(@NotNull l3 l3Var, @NotNull w0 w0Var) throws Exception {
                return b.values()[l3Var.nextInt()];
            }
        }

        @Override // io.sentry.h2
        public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
            m3Var.a(ordinal());
        }
    }

    public e() {
        super(d.b.MouseInteraction);
        this.f28175h = 2;
    }

    private void m(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        new d.c().a(this, m3Var, w0Var);
        m3Var.e("type").o(w0Var, this.f28171d);
        m3Var.e("id").a(this.f28172e);
        m3Var.e(ViewHierarchyNode.JsonKeys.X).b(this.f28173f);
        m3Var.e(ViewHierarchyNode.JsonKeys.Y).b(this.f28174g);
        m3Var.e("pointerType").a(this.f28175h);
        m3Var.e("pointerId").a(this.f28176i);
        Map<String, Object> map = this.f28178k;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28178k.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }

    public void n(@Nullable Map<String, Object> map) {
        this.f28178k = map;
    }

    public void o(@Nullable Map<String, Object> map) {
        this.f28177j = map;
    }

    @Override // io.sentry.h2
    public void serialize(@NotNull m3 m3Var, @NotNull w0 w0Var) throws IOException {
        m3Var.h();
        new b.C0587b().a(this, m3Var, w0Var);
        m3Var.e("data");
        m(m3Var, w0Var);
        Map<String, Object> map = this.f28177j;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = this.f28177j.get(str);
                m3Var.e(str);
                m3Var.o(w0Var, obj);
            }
        }
        m3Var.k();
    }
}
