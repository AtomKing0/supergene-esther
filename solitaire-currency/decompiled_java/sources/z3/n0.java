package z3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: UdpDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f37454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f37455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DatagramPacket f37456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Uri f37457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private DatagramSocket f37458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private MulticastSocket f37459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private InetAddress f37460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f37461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f37462m;

    /* JADX INFO: compiled from: UdpDataSource.java */
    public static final class a extends l {
        public a(Throwable th, int i10) {
            super(th, i10);
        }
    }

    public n0() {
        this(2000);
    }

    @Override // z3.k
    public long a(o oVar) throws a {
        Uri uri = oVar.f37463a;
        this.f37457h = uri;
        String str = (String) a4.a.e(uri.getHost());
        int port = this.f37457h.getPort();
        e(oVar);
        try {
            this.f37460k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f37460k, port);
            if (this.f37460k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f37459j = multicastSocket;
                multicastSocket.joinGroup(this.f37460k);
                this.f37458i = this.f37459j;
            } else {
                this.f37458i = new DatagramSocket(inetSocketAddress);
            }
            this.f37458i.setSoTimeout(this.f37454e);
            this.f37461l = true;
            f(oVar);
            return -1L;
        } catch (IOException e10) {
            throw new a(e10, 2001);
        } catch (SecurityException e11) {
            throw new a(e11, 2006);
        }
    }

    @Override // z3.k
    public void close() {
        this.f37457h = null;
        MulticastSocket multicastSocket = this.f37459j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) a4.a.e(this.f37460k));
            } catch (IOException unused) {
            }
            this.f37459j = null;
        }
        DatagramSocket datagramSocket = this.f37458i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f37458i = null;
        }
        this.f37460k = null;
        this.f37462m = 0;
        if (this.f37461l) {
            this.f37461l = false;
            d();
        }
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        return this.f37457h;
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) throws a {
        if (i11 == 0) {
            return 0;
        }
        if (this.f37462m == 0) {
            try {
                ((DatagramSocket) a4.a.e(this.f37458i)).receive(this.f37456g);
                int length = this.f37456g.getLength();
                this.f37462m = length;
                c(length);
            } catch (SocketTimeoutException e10) {
                throw new a(e10, 2002);
            } catch (IOException e11) {
                throw new a(e11, 2001);
            }
        }
        int length2 = this.f37456g.getLength();
        int i12 = this.f37462m;
        int iMin = Math.min(i12, i11);
        System.arraycopy(this.f37455f, length2 - i12, bArr, i10, iMin);
        this.f37462m -= iMin;
        return iMin;
    }

    public n0(int i10) {
        this(i10, 8000);
    }

    public n0(int i10, int i11) {
        super(true);
        this.f37454e = i11;
        byte[] bArr = new byte[i10];
        this.f37455f = bArr;
        this.f37456g = new DatagramPacket(bArr, 0, i10);
    }
}
