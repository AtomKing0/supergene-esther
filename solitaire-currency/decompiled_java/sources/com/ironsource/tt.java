package com.ironsource;

import com.ironsource.js;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class tt implements yn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k1 f15479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Runnable f15480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f15481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<xn> f15482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final js f15483e;

    /* JADX WARN: Multi-variable type inference failed */
    public tt(@NotNull k1 adTools, @NotNull Runnable task, long j10, @NotNull List<? extends xn> pauseTriggers) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(task, "task");
        kotlin.jvm.internal.t.i(pauseTriggers, "pauseTriggers");
        this.f15479a = adTools;
        this.f15480b = task;
        this.f15481c = j10;
        this.f15482d = pauseTriggers;
        this.f15483e = new js(adTools.a(), new Runnable() { // from class: com.ironsource.q00
            @Override // java.lang.Runnable
            public final void run() {
                tt.b(this.f14425a);
            }
        }, j10);
        for (xn xnVar : pauseTriggers) {
            xnVar.a(this);
            if (xnVar.d()) {
                a(xnVar.b());
            }
        }
        if (a()) {
            js.a aVarB = this.f15483e.b();
            List<xn> list = this.f15482d;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((xn) obj).d()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                long jC = ((xn) next).c();
                do {
                    Object next2 = it.next();
                    long jC2 = ((xn) next2).c();
                    if (jC > jC2) {
                        next = next2;
                        jC = jC2;
                    }
                } while (it.hasNext());
            }
            a(((xn) next).b(), aVarB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(tt this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        Iterator<T> it = this$0.f15482d.iterator();
        while (it.hasNext()) {
            ((xn) it.next()).a((yn) null);
        }
        this$0.f15483e.b();
    }

    private final void b() {
        c();
        this.f15480b.run();
    }

    public /* synthetic */ tt(k1 k1Var, Runnable runnable, long j10, List list, int i10, kotlin.jvm.internal.k kVar) {
        this(k1Var, runnable, j10, (i10 & 8) != 0 ? new ArrayList() : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(tt this$0, xn pauseableTrigger) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(pauseableTrigger, "$pauseableTrigger");
        this$0.a(pauseableTrigger.b());
        if (!this$0.a() || this$0.f15483e.e()) {
            return;
        }
        this$0.a(pauseableTrigger.b(), this$0.f15483e.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(tt this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.b();
    }

    public final void c() {
        this.f15479a.d(new Runnable() { // from class: com.ironsource.t00
            @Override // java.lang.Runnable
            public final void run() {
                tt.a(this.f15360a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(tt this$0, xn pauseableTrigger) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(pauseableTrigger, "$pauseableTrigger");
        this$0.b(pauseableTrigger.b());
        if (this$0.a() || !this$0.f15483e.e()) {
            return;
        }
        this$0.b(pauseableTrigger.b(), this$0.f15483e.a());
    }

    @Override // com.ironsource.yn
    public void a(@NotNull final xn pauseableTrigger) {
        kotlin.jvm.internal.t.i(pauseableTrigger, "pauseableTrigger");
        this.f15479a.d(new Runnable() { // from class: com.ironsource.s00
            @Override // java.lang.Runnable
            public final void run() {
                tt.a(this.f14753a, pauseableTrigger);
            }
        });
    }

    private final void a(String str) {
        this.f15479a.e().g().d(str);
    }

    @Override // com.ironsource.yn
    public void b(@NotNull final xn pauseableTrigger) {
        kotlin.jvm.internal.t.i(pauseableTrigger, "pauseableTrigger");
        this.f15479a.d(new Runnable() { // from class: com.ironsource.r00
            @Override // java.lang.Runnable
            public final void run() {
                tt.b(this.f14618a, pauseableTrigger);
            }
        });
    }

    private final void a(String str, js.a aVar) {
        this.f15479a.e().g().a(str, this.f15481c, aVar.c(), aVar.d());
    }

    private final void b(String str) {
        this.f15479a.e().g().e(str);
    }

    private final boolean a() {
        List<xn> list = this.f15482d;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((xn) it.next()).d()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void b(String str, js.a aVar) {
        this.f15479a.e().g().b(str, this.f15481c, aVar.c(), aVar.d());
    }
}
