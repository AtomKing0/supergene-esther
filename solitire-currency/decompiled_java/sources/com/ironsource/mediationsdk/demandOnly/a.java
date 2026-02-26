package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.f5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.ironsource.mediationsdk.demandOnly.a$a, reason: collision with other inner class name */
    public static final class C0259a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<f5> f13372a;

        /* JADX WARN: Multi-variable type inference failed */
        public C0259a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        @Nullable
        public f5 a(@NotNull String instanceName) {
            Object next;
            t.i(instanceName, "instanceName");
            Iterator<T> it = this.f13372a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (t.d(((f5) next).c(), instanceName)) {
                    break;
                }
            }
            return (f5) next;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        @NotNull
        public String b() {
            if (this.f13372a.isEmpty()) {
                return "";
            }
            return '1' + ((f5) d0.i0(this.f13372a)).c();
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        @Nullable
        public f5 get(int i10) {
            if (i10 < 0 || i10 >= this.f13372a.size()) {
                return null;
            }
            return this.f13372a.get(i10);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public boolean isEmpty() {
            return this.f13372a.isEmpty();
        }

        public C0259a(@NotNull List<f5> waterfall) {
            t.i(waterfall, "waterfall");
            this.f13372a = waterfall;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        @NotNull
        public List<f5> a() {
            return this.f13372a;
        }

        public /* synthetic */ C0259a(List list, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? new ArrayList() : list);
        }
    }

    @Nullable
    f5 a(@NotNull String str);

    @NotNull
    List<f5> a();

    @NotNull
    String b();

    @Nullable
    f5 get(int i10);

    boolean isEmpty();
}
