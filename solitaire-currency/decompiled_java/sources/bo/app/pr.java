package bo.app;

import com.braze.support.BrazeLogger;
import com.ironsource.v8;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class pr {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f3642o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f3643p = BrazeLogger.getBrazeLogTag((Class<?>) pr.class);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final lr f3644q = new lr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f3645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f3646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f3647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f3648d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BufferedWriter f3653i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3655k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f3652h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f3654j = new LinkedHashMap(0, 0.75f, true);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f3656l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ThreadPoolExecutor f3657m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final kr f3658n = new kr(this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3649e = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3651g = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3650f = 52428800;

    public pr(File file) {
        this.f3645a = file;
        this.f3646b = new File(file, "journal");
        this.f3647c = new File(file, "journal.tmp");
        this.f3648d = new File(file, "journal.bkp");
    }

    public final synchronized or b(String str) {
        InputStream inputStream;
        if (this.f3653i == null) {
            throw new IllegalStateException("cache is closed");
        }
        if (!f3642o.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
        vu vuVar = (vu) this.f3654j.get(str);
        if (vuVar == null) {
            return null;
        }
        if (!vuVar.f4139c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f3651g];
        for (int i10 = 0; i10 < this.f3651g; i10++) {
            try {
                inputStreamArr[i10] = new FileInputStream(new File(vuVar.f4142f, vuVar.f4137a + "." + i10));
            } catch (FileNotFoundException unused) {
                for (int i11 = 0; i11 < this.f3651g && (inputStream = inputStreamArr[i11]) != null; i11++) {
                    Charset charset = di0.f2659a;
                    try {
                        inputStream.close();
                    } catch (RuntimeException e10) {
                        throw e10;
                    } catch (Exception unused2) {
                    }
                }
                return null;
            }
        }
        this.f3655k++;
        this.f3653i.append((CharSequence) ("READ " + str + '\n'));
        if (a()) {
            this.f3657m.submit(this.f3658n);
        }
        return new or(inputStreamArr);
    }

    public final void c(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i10 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i10);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i10);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f3654j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i10, iIndexOf2);
        }
        vu vuVar = (vu) this.f3654j.get(strSubstring);
        if (vuVar == null) {
            vuVar = new vu(strSubstring, this.f3651g, this.f3645a);
            this.f3654j.put(strSubstring, vuVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                vuVar.f4140d = new nr(this, vuVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        vuVar.f4139c = true;
        vuVar.f4140d = null;
        if (strArrSplit.length != vuVar.f4141e) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i11 = 0; i11 < strArrSplit.length; i11++) {
            try {
                vuVar.f4138b[i11] = Long.parseLong(strArrSplit[i11]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }

    public final synchronized void d() {
        BufferedWriter bufferedWriter = this.f3653i;
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3647c), di0.f2659a));
        try {
            bufferedWriter2.write("libcore.io.DiskLruCache");
            bufferedWriter2.write("\n");
            bufferedWriter2.write("1");
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.f3649e));
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.f3651g));
            bufferedWriter2.write("\n");
            bufferedWriter2.write("\n");
            for (vu vuVar : this.f3654j.values()) {
                if (vuVar.f4140d != null) {
                    bufferedWriter2.write("DIRTY " + vuVar.f4137a + '\n');
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("CLEAN ");
                    sb.append(vuVar.f4137a);
                    StringBuilder sb2 = new StringBuilder();
                    for (long j10 : vuVar.f4138b) {
                        sb2.append(' ');
                        sb2.append(j10);
                    }
                    sb.append(sb2.toString());
                    sb.append('\n');
                    bufferedWriter2.write(sb.toString());
                }
            }
            bufferedWriter2.close();
            if (this.f3646b.exists()) {
                File file = this.f3646b;
                File file2 = this.f3648d;
                if (file2.exists() && !file2.delete()) {
                    throw new IOException();
                }
                if (!file.renameTo(file2)) {
                    throw new IOException();
                }
            }
            if (!this.f3647c.renameTo(this.f3646b)) {
                throw new IOException();
            }
            this.f3648d.delete();
            this.f3653i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3646b, true), di0.f2659a));
        } finally {
        }
    }

    public static void a(pr prVar, nr nrVar, boolean z10) {
        synchronized (prVar) {
            vu vuVar = nrVar.f3516a;
            if (vuVar.f4140d != nrVar) {
                throw new IllegalStateException();
            }
            if (z10 && !vuVar.f4139c) {
                for (int i10 = 0; i10 < prVar.f3651g; i10++) {
                    if (!nrVar.f3517b[i10]) {
                        a(nrVar.f3519d, nrVar, false);
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                    }
                    if (!vuVar.a(i10).exists()) {
                        a(nrVar.f3519d, nrVar, false);
                        return;
                    }
                }
            }
            for (int i11 = 0; i11 < prVar.f3651g; i11++) {
                File fileA = vuVar.a(i11);
                if (z10) {
                    if (fileA.exists()) {
                        File file = new File(vuVar.f4142f, vuVar.f4137a + "." + i11);
                        fileA.renameTo(file);
                        long j10 = vuVar.f4138b[i11];
                        long length = file.length();
                        vuVar.f4138b[i11] = length;
                        prVar.f3652h = (prVar.f3652h - j10) + length;
                    }
                } else if (fileA.exists() && !fileA.delete()) {
                    throw new IOException();
                }
            }
            prVar.f3655k++;
            vuVar.f4140d = null;
            if (vuVar.f4139c || z10) {
                vuVar.f4139c = true;
                BufferedWriter bufferedWriter = prVar.f3653i;
                StringBuilder sb = new StringBuilder("CLEAN ");
                sb.append(vuVar.f4137a);
                StringBuilder sb2 = new StringBuilder();
                for (long j11 : vuVar.f4138b) {
                    sb2.append(' ');
                    sb2.append(j11);
                }
                sb.append(sb2.toString());
                sb.append('\n');
                bufferedWriter.write(sb.toString());
                if (z10) {
                    prVar.f3656l++;
                }
            } else {
                prVar.f3654j.remove(vuVar.f4137a);
                prVar.f3653i.write("REMOVE " + vuVar.f4137a + '\n');
            }
            prVar.f3653i.flush();
            if (prVar.f3652h > prVar.f3650f || prVar.a()) {
                prVar.f3657m.submit(prVar.f3658n);
            }
        }
    }

    public final void b() throws IOException {
        File file = this.f3647c;
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
        Iterator it = this.f3654j.values().iterator();
        while (it.hasNext()) {
            vu vuVar = (vu) it.next();
            int i10 = 0;
            if (vuVar.f4140d == null) {
                while (i10 < this.f3651g) {
                    this.f3652h += vuVar.f4138b[i10];
                    i10++;
                }
            } else {
                vuVar.f4140d = null;
                while (i10 < this.f3651g) {
                    File file2 = new File(vuVar.f4142f, vuVar.f4137a + "." + i10);
                    if (file2.exists() && !file2.delete()) {
                        throw new IOException();
                    }
                    File fileA = vuVar.a(i10);
                    if (fileA.exists() && !fileA.delete()) {
                        throw new IOException();
                    }
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void c() {
        wc0 wc0Var = new wc0(new FileInputStream(this.f3646b), di0.f2659a);
        try {
            String strA = wc0Var.a();
            String strA2 = wc0Var.a();
            String strA3 = wc0Var.a();
            String strA4 = wc0Var.a();
            String strA5 = wc0Var.a();
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.f3649e).equals(strA3) || !Integer.toString(this.f3651g).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + v8.i.f15839e);
            }
            int i10 = 0;
            while (true) {
                try {
                    c(wc0Var.a());
                    i10++;
                } catch (EOFException unused) {
                    this.f3655k = i10 - this.f3654j.size();
                    if (wc0Var.f4196e == -1) {
                        d();
                    } else {
                        this.f3653i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3646b, true), di0.f2659a));
                    }
                    try {
                        wc0Var.close();
                        return;
                    } catch (RuntimeException e10) {
                        throw e10;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                wc0Var.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final synchronized void d(String str) {
        if (this.f3653i != null) {
            if (f3642o.matcher(str).matches()) {
                vu vuVar = (vu) this.f3654j.get(str);
                if (vuVar != null && vuVar.f4140d == null) {
                    for (int i10 = 0; i10 < this.f3651g; i10++) {
                        File file = new File(vuVar.f4142f, vuVar.f4137a + "." + i10);
                        if (file.exists() && !file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                        long j10 = this.f3652h;
                        long[] jArr = vuVar.f4138b;
                        this.f3652h = j10 - jArr[i10];
                        jArr[i10] = 0;
                    }
                    this.f3655k++;
                    this.f3653i.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.f3654j.remove(str);
                    if (a()) {
                        this.f3657m.submit(this.f3658n);
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
        throw new IllegalStateException("cache is closed");
    }

    public final nr a(String str) {
        synchronized (this) {
            if (this.f3653i != null) {
                if (f3642o.matcher(str).matches()) {
                    vu vuVar = (vu) this.f3654j.get(str);
                    if (vuVar == null) {
                        vuVar = new vu(str, this.f3651g, this.f3645a);
                        this.f3654j.put(str, vuVar);
                    } else if (vuVar.f4140d != null) {
                        return null;
                    }
                    nr nrVar = new nr(this, vuVar);
                    vuVar.f4140d = nrVar;
                    this.f3653i.write("DIRTY " + str + '\n');
                    this.f3653i.flush();
                    return nrVar;
                }
                throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
            }
            throw new IllegalStateException("cache is closed");
        }
    }

    public final boolean a() {
        int i10 = this.f3655k;
        return i10 >= 2000 && i10 >= this.f3654j.size();
    }

    public static pr a(File file) throws IOException {
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else if (!file2.renameTo(file3)) {
                throw new IOException();
            }
        }
        pr prVar = new pr(file);
        if (prVar.f3646b.exists()) {
            try {
                prVar.c();
                prVar.b();
                return prVar;
            } catch (IOException e10) {
                BrazeLogger.w(f3643p, "DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                synchronized (prVar) {
                    if (prVar.f3653i != null) {
                        Iterator it = new ArrayList(prVar.f3654j.values()).iterator();
                        while (it.hasNext()) {
                            nr nrVar = ((vu) it.next()).f4140d;
                            if (nrVar != null) {
                                a(nrVar.f3519d, nrVar, false);
                            }
                        }
                        while (prVar.f3652h > prVar.f3650f) {
                            prVar.d((String) ((Map.Entry) prVar.f3654j.entrySet().iterator().next()).getKey());
                        }
                        prVar.f3653i.close();
                        prVar.f3653i = null;
                    }
                    di0.a(prVar.f3645a);
                }
            }
        }
        file.mkdirs();
        pr prVar2 = new pr(file);
        prVar2.d();
        return prVar2;
    }
}
