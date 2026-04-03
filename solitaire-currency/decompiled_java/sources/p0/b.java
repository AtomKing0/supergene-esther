package p0;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.ironsource.v8;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f32375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f32376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f32377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f32378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f32379e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f32380f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f32381g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Writer f32383i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f32385k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f32382h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, d> f32384j = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f32386l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f32387m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0647b(null));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Callable<Void> f32388n = new a();

    /* JADX INFO: compiled from: DiskLruCache.java */
    class a implements Callable<Void> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (b.this) {
                if (b.this.f32383i == null) {
                    return null;
                }
                b.this.Q0();
                if (b.this.I0()) {
                    b.this.N0();
                    b.this.f32385k = 0;
                }
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: p0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.java */
    private static final class ThreadFactoryC0647b implements ThreadFactory {
        private ThreadFactoryC0647b() {
        }

        /* synthetic */ ThreadFactoryC0647b(a aVar) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f32390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f32391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f32392c;

        /* synthetic */ c(b bVar, d dVar, a aVar) {
            this(dVar);
        }

        public void a() throws IOException {
            b.this.O(this, false);
        }

        public void b() {
            if (this.f32392c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() throws IOException {
            b.this.O(this, true);
            this.f32392c = true;
        }

        public File f(int i10) throws IOException {
            File fileK;
            synchronized (b.this) {
                if (this.f32390a.f32399f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f32390a.f32398e) {
                    this.f32391b[i10] = true;
                }
                fileK = this.f32390a.k(i10);
                if (!b.this.f32375a.exists()) {
                    b.this.f32375a.mkdirs();
                }
            }
            return fileK;
        }

        private c(d dVar) {
            this.f32390a = dVar;
            this.f32391b = dVar.f32398e ? null : new boolean[b.this.f32381g];
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f32394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f32395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        File[] f32396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        File[] f32397d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f32398e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f32399f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f32400g;

        /* synthetic */ d(b bVar, String str, a aVar) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != b.this.f32381g) {
                throw m(strArr);
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    this.f32395b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public File j(int i10) {
            return this.f32396c[i10];
        }

        public File k(int i10) {
            return this.f32397d[i10];
        }

        public String l() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j10 : this.f32395b) {
                sb.append(' ');
                sb.append(j10);
            }
            return sb.toString();
        }

        private d(String str) {
            this.f32394a = str;
            this.f32395b = new long[b.this.f32381g];
            this.f32396c = new File[b.this.f32381g];
            this.f32397d = new File[b.this.f32381g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i10 = 0; i10 < b.this.f32381g; i10++) {
                sb.append(i10);
                this.f32396c[i10] = new File(b.this.f32375a, sb.toString());
                sb.append(".tmp");
                this.f32397d[i10] = new File(b.this.f32375a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f32402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f32403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f32404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File[] f32405d;

        /* synthetic */ e(b bVar, String str, long j10, File[] fileArr, long[] jArr, a aVar) {
            this(str, j10, fileArr, jArr);
        }

        public File a(int i10) {
            return this.f32405d[i10];
        }

        private e(String str, long j10, File[] fileArr, long[] jArr) {
            this.f32402a = str;
            this.f32403b = j10;
            this.f32405d = fileArr;
            this.f32404c = jArr;
        }
    }

    private b(File file, int i10, int i11, long j10) {
        this.f32375a = file;
        this.f32379e = i10;
        this.f32376b = new File(file, "journal");
        this.f32377c = new File(file, "journal.tmp");
        this.f32378d = new File(file, "journal.bkp");
        this.f32381g = i11;
        this.f32380f = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I0() {
        int i10 = this.f32385k;
        return i10 >= 2000 && i10 >= this.f32384j.size();
    }

    private void J() {
        if (this.f32383i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static b J0(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                P0(file2, file3, false);
            }
        }
        b bVar = new b(file, i10, i11, j10);
        if (bVar.f32376b.exists()) {
            try {
                bVar.L0();
                bVar.K0();
                return bVar;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                bVar.R();
            }
        }
        file.mkdirs();
        b bVar2 = new b(file, i10, i11, j10);
        bVar2.N0();
        return bVar2;
    }

    private void K0() throws IOException {
        S(this.f32377c);
        Iterator<d> it = this.f32384j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f32399f == null) {
                while (i10 < this.f32381g) {
                    this.f32382h += next.f32395b[i10];
                    i10++;
                }
            } else {
                next.f32399f = null;
                while (i10 < this.f32381g) {
                    S(next.j(i10));
                    S(next.k(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    @TargetApi(26)
    private static void L(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private void L0() throws IOException {
        p0.c cVar = new p0.c(new FileInputStream(this.f32376b), p0.d.f32413a);
        try {
            String strN = cVar.n();
            String strN2 = cVar.n();
            String strN3 = cVar.n();
            String strN4 = cVar.n();
            String strN5 = cVar.n();
            if (!"libcore.io.DiskLruCache".equals(strN) || !"1".equals(strN2) || !Integer.toString(this.f32379e).equals(strN3) || !Integer.toString(this.f32381g).equals(strN4) || !"".equals(strN5)) {
                throw new IOException("unexpected journal header: [" + strN + ", " + strN2 + ", " + strN4 + ", " + strN5 + v8.i.f15839e);
            }
            int i10 = 0;
            while (true) {
                try {
                    M0(cVar.n());
                    i10++;
                } catch (EOFException unused) {
                    this.f32385k = i10 - this.f32384j.size();
                    if (cVar.i()) {
                        N0();
                    } else {
                        this.f32383i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f32376b, true), p0.d.f32413a));
                    }
                    p0.d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            p0.d.a(cVar);
            throw th;
        }
    }

    private void M0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i10 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i10);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i10);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f32384j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        d dVar = this.f32384j.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.f32384j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f32398e = true;
            dVar.f32399f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f32399f = new c(this, dVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void N0() throws IOException {
        Writer writer = this.f32383i;
        if (writer != null) {
            L(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f32377c), p0.d.f32413a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f32379e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f32381g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.f32384j.values()) {
                if (dVar.f32399f != null) {
                    bufferedWriter.write("DIRTY " + dVar.f32394a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f32394a + dVar.l() + '\n');
                }
            }
            L(bufferedWriter);
            if (this.f32376b.exists()) {
                P0(this.f32376b, this.f32378d, true);
            }
            P0(this.f32377c, this.f32376b, false);
            this.f32378d.delete();
            this.f32383i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f32376b, true), p0.d.f32413a));
        } catch (Throwable th) {
            L(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void O(c cVar, boolean z10) throws IOException {
        d dVar = cVar.f32390a;
        if (dVar.f32399f != cVar) {
            throw new IllegalStateException();
        }
        if (z10 && !dVar.f32398e) {
            for (int i10 = 0; i10 < this.f32381g; i10++) {
                if (!cVar.f32391b[i10]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                }
                if (!dVar.k(i10).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i11 = 0; i11 < this.f32381g; i11++) {
            File fileK = dVar.k(i11);
            if (!z10) {
                S(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i11);
                fileK.renameTo(fileJ);
                long j10 = dVar.f32395b[i11];
                long length = fileJ.length();
                dVar.f32395b[i11] = length;
                this.f32382h = (this.f32382h - j10) + length;
            }
        }
        this.f32385k++;
        dVar.f32399f = null;
        if (dVar.f32398e || z10) {
            dVar.f32398e = true;
            this.f32383i.append((CharSequence) "CLEAN");
            this.f32383i.append(' ');
            this.f32383i.append((CharSequence) dVar.f32394a);
            this.f32383i.append((CharSequence) dVar.l());
            this.f32383i.append('\n');
            if (z10) {
                long j11 = this.f32386l;
                this.f32386l = 1 + j11;
                dVar.f32400g = j11;
            }
        } else {
            this.f32384j.remove(dVar.f32394a);
            this.f32383i.append((CharSequence) "REMOVE");
            this.f32383i.append(' ');
            this.f32383i.append((CharSequence) dVar.f32394a);
            this.f32383i.append('\n');
        }
        i0(this.f32383i);
        if (this.f32382h > this.f32380f || I0()) {
            this.f32387m.submit(this.f32388n);
        }
    }

    private static void P0(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            S(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() throws IOException {
        while (this.f32382h > this.f32380f) {
            O0(this.f32384j.entrySet().iterator().next().getKey());
        }
    }

    private static void S(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c h0(String str, long j10) throws IOException {
        J();
        d dVar = this.f32384j.get(str);
        a aVar = null;
        if (j10 != -1 && (dVar == null || dVar.f32400g != j10)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.f32384j.put(str, dVar);
        } else if (dVar.f32399f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f32399f = cVar;
        this.f32383i.append((CharSequence) "DIRTY");
        this.f32383i.append(' ');
        this.f32383i.append((CharSequence) str);
        this.f32383i.append('\n');
        i0(this.f32383i);
        return cVar;
    }

    @TargetApi(26)
    private static void i0(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public synchronized e G0(String str) throws IOException {
        J();
        d dVar = this.f32384j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f32398e) {
            return null;
        }
        for (File file : dVar.f32396c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f32385k++;
        this.f32383i.append((CharSequence) "READ");
        this.f32383i.append(' ');
        this.f32383i.append((CharSequence) str);
        this.f32383i.append('\n');
        if (I0()) {
            this.f32387m.submit(this.f32388n);
        }
        return new e(this, str, dVar.f32400g, dVar.f32396c, dVar.f32395b, null);
    }

    public synchronized boolean O0(String str) throws IOException {
        J();
        d dVar = this.f32384j.get(str);
        if (dVar != null && dVar.f32399f == null) {
            for (int i10 = 0; i10 < this.f32381g; i10++) {
                File fileJ = dVar.j(i10);
                if (fileJ.exists() && !fileJ.delete()) {
                    throw new IOException("failed to delete " + fileJ);
                }
                this.f32382h -= dVar.f32395b[i10];
                dVar.f32395b[i10] = 0;
            }
            this.f32385k++;
            this.f32383i.append((CharSequence) "REMOVE");
            this.f32383i.append(' ');
            this.f32383i.append((CharSequence) str);
            this.f32383i.append('\n');
            this.f32384j.remove(str);
            if (I0()) {
                this.f32387m.submit(this.f32388n);
            }
            return true;
        }
        return false;
    }

    public void R() throws IOException {
        close();
        p0.d.b(this.f32375a);
    }

    public c W(String str) throws IOException {
        return h0(str, -1L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f32383i == null) {
            return;
        }
        for (d dVar : new ArrayList(this.f32384j.values())) {
            if (dVar.f32399f != null) {
                dVar.f32399f.a();
            }
        }
        Q0();
        L(this.f32383i);
        this.f32383i = null;
    }
}
