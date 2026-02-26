package io.sentry.android.core.internal.threaddump;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Lines.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ArrayList<? extends a> f27270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f27271b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f27272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f27273d;

    public b(@NotNull ArrayList<? extends a> arrayList) {
        this.f27270a = arrayList;
        this.f27272c = arrayList.size();
    }

    public static b c(@NotNull BufferedReader bufferedReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new b(arrayList);
            }
            i10++;
            arrayList.add(new a(i10, line));
        }
    }

    public boolean a() {
        return this.f27273d < this.f27272c;
    }

    @Nullable
    public a b() {
        int i10 = this.f27273d;
        if (i10 < this.f27271b || i10 >= this.f27272c) {
            return null;
        }
        ArrayList<? extends a> arrayList = this.f27270a;
        this.f27273d = i10 + 1;
        return arrayList.get(i10);
    }

    public void d() {
        this.f27273d--;
    }
}
