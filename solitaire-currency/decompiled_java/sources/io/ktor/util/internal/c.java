package io.ktor.util.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f26641a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f26642b = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26643c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_removedRef");

    @NotNull
    volatile /* synthetic */ Object _next = this;

    @NotNull
    volatile /* synthetic */ Object _prev = this;

    @NotNull
    private volatile /* synthetic */ Object _removedRef = null;

    private final c b(c cVar, d dVar) {
        Object obj;
        while (true) {
            c cVar2 = null;
            while (true) {
                obj = cVar._next;
                if (obj == dVar) {
                    return cVar;
                }
                if (obj instanceof d) {
                    ((d) obj).a(cVar);
                } else if (!(obj instanceof e)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof e) {
                        return null;
                    }
                    if (obj != this) {
                        t.g(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode{ io.ktor.util.internal.LockFreeLinkedListKt.Node }");
                        cVar2 = cVar;
                        cVar = (c) obj;
                    } else {
                        if (obj2 == cVar) {
                            return null;
                        }
                        if (androidx.concurrent.futures.a.a(f26642b, this, obj2, cVar) && !(cVar._prev instanceof e)) {
                            return null;
                        }
                    }
                } else {
                    if (cVar2 != null) {
                        break;
                    }
                    cVar = b.a(cVar._prev);
                }
            }
            cVar.h();
            androidx.concurrent.futures.a.a(f26641a, cVar2, cVar, ((e) obj).f26644a);
            cVar = cVar2;
        }
    }

    private final c c() {
        c cVarF = this;
        while (!(cVarF instanceof a)) {
            cVarF = cVarF.f();
            if (!(cVarF != this)) {
                throw new IllegalStateException("Cannot loop to this while looking for list head".toString());
            }
        }
        return cVarF;
    }

    private final void d(c cVar) {
        g();
        cVar.b(b.a(this._prev), null);
    }

    private final c h() {
        Object obj;
        c cVarC;
        do {
            obj = this._prev;
            if (obj instanceof e) {
                return ((e) obj).f26644a;
            }
            if (obj == this) {
                cVarC = c();
            } else {
                t.g(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode{ io.ktor.util.internal.LockFreeLinkedListKt.Node }");
                cVarC = (c) obj;
            }
        } while (!androidx.concurrent.futures.a.a(f26642b, this, obj, cVarC.j()));
        return (c) obj;
    }

    private final e j() {
        e eVar = (e) this._removedRef;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        f26643c.lazySet(this, eVar2);
        return eVar2;
    }

    @NotNull
    public final Object e() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof d)) {
                return obj;
            }
            ((d) obj).a(this);
        }
    }

    @NotNull
    public final c f() {
        return b.a(e());
    }

    public final void g() {
        Object objE;
        c cVarH = h();
        Object obj = this._next;
        t.g(obj, "null cannot be cast to non-null type io.ktor.util.internal.Removed");
        c cVar = ((e) obj).f26644a;
        while (true) {
            c cVar2 = null;
            while (true) {
                Object objE2 = cVar.e();
                if (objE2 instanceof e) {
                    cVar.h();
                    cVar = ((e) objE2).f26644a;
                } else {
                    objE = cVarH.e();
                    if (objE instanceof e) {
                        if (cVar2 != null) {
                            break;
                        } else {
                            cVarH = b.a(cVarH._prev);
                        }
                    } else if (objE != this) {
                        t.g(objE, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode{ io.ktor.util.internal.LockFreeLinkedListKt.Node }");
                        c cVar3 = (c) objE;
                        if (cVar3 == cVar) {
                            return;
                        }
                        cVar2 = cVarH;
                        cVarH = cVar3;
                    } else if (androidx.concurrent.futures.a.a(f26641a, cVarH, this, cVar)) {
                        return;
                    }
                }
            }
            cVarH.h();
            androidx.concurrent.futures.a.a(f26641a, cVar2, cVarH, ((e) objE).f26644a);
            cVarH = cVar2;
        }
    }

    public boolean i() {
        Object objE;
        c cVar;
        do {
            objE = e();
            if ((objE instanceof e) || objE == this) {
                return false;
            }
            t.g(objE, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode{ io.ktor.util.internal.LockFreeLinkedListKt.Node }");
            cVar = (c) objE;
        } while (!androidx.concurrent.futures.a.a(f26641a, this, objE, cVar.j()));
        d(cVar);
        return true;
    }

    @NotNull
    public String toString() {
        return o0.b(getClass()).getSimpleName() + '@' + hashCode();
    }
}
