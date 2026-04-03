package f9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: FileReadWrite.kt */
/* JADX INFO: loaded from: classes5.dex */
public class k extends j {

    /* JADX INFO: compiled from: FileReadWrite.kt */
    static final class a extends v implements h9.l<String, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f25763g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList<String> arrayList) {
            super(1);
            this.f25763g = arrayList;
        }

        public final void b(@NotNull String it) {
            t.i(it, "it");
            this.f25763g.add(it);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(String str) {
            b(str);
            return k0.f35197a;
        }
    }

    public static void c(@NotNull File file, @NotNull byte[] array) {
        t.i(file, "<this>");
        t.i(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(array);
            k0 k0Var = k0.f35197a;
            c.a(fileOutputStream, null);
        } finally {
        }
    }

    public static final void d(@NotNull File file, @NotNull Charset charset, @NotNull h9.l<? super String, k0> action) {
        t.i(file, "<this>");
        t.i(charset, "charset");
        t.i(action, "action");
        p.c(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), action);
    }

    @NotNull
    public static final List<String> e(@NotNull File file, @NotNull Charset charset) {
        t.i(file, "<this>");
        t.i(charset, "charset");
        ArrayList arrayList = new ArrayList();
        d(file, charset, new a(arrayList));
        return arrayList;
    }

    public static /* synthetic */ List f(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = p9.d.f32952b;
        }
        return e(file, charset);
    }

    @NotNull
    public static final String g(@NotNull File file, @NotNull Charset charset) {
        t.i(file, "<this>");
        t.i(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strE = p.e(inputStreamReader);
            c.a(inputStreamReader, null);
            return strE;
        } finally {
        }
    }

    public static /* synthetic */ String h(File file, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = p9.d.f32952b;
        }
        return g(file, charset);
    }

    public static final void i(@NotNull File file, @NotNull byte[] array) {
        t.i(file, "<this>");
        t.i(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            k0 k0Var = k0.f35197a;
            c.a(fileOutputStream, null);
        } finally {
        }
    }

    public static void j(@NotNull File file, @NotNull String text, @NotNull Charset charset) {
        t.i(file, "<this>");
        t.i(text, "text");
        t.i(charset, "charset");
        byte[] bytes = text.getBytes(charset);
        t.h(bytes, "this as java.lang.String).getBytes(charset)");
        i(file, bytes);
    }

    public static /* synthetic */ void k(File file, String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = p9.d.f32952b;
        }
        j(file, str, charset);
    }
}
