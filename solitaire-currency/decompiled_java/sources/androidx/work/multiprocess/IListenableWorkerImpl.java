package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.work.multiprocess.IWorkManagerImplCallback;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface IListenableWorkerImpl extends IInterface {
    public static final String DESCRIPTOR = "androidx$work$multiprocess$IListenableWorkerImpl".replace('$', '.');

    void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IListenableWorkerImpl {
        static final int TRANSACTION_interrupt = 2;
        static final int TRANSACTION_startWork = 1;

        private static class Proxy implements IListenableWorkerImpl {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IListenableWorkerImpl.DESCRIPTOR;
            }

            @Override // androidx.work.multiprocess.IListenableWorkerImpl
            public void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IListenableWorkerImpl.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeStrongInterface(iWorkManagerImplCallback);
                    this.mRemote.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.work.multiprocess.IListenableWorkerImpl
            public void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IListenableWorkerImpl.DESCRIPTOR);
                    parcelObtain.writeByteArray(bArr);
                    parcelObtain.writeStrongInterface(iWorkManagerImplCallback);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IListenableWorkerImpl.DESCRIPTOR);
        }

        public static IListenableWorkerImpl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IListenableWorkerImpl.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IListenableWorkerImpl)) ? new Proxy(iBinder) : (IListenableWorkerImpl) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str = IListenableWorkerImpl.DESCRIPTOR;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 == 1) {
                startWork(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
            } else {
                if (i10 != 2) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                interrupt(parcel.createByteArray(), IWorkManagerImplCallback.Stub.asInterface(parcel.readStrongBinder()));
            }
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }

    public static class Default implements IListenableWorkerImpl {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.work.multiprocess.IListenableWorkerImpl
        public void interrupt(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }

        @Override // androidx.work.multiprocess.IListenableWorkerImpl
        public void startWork(byte[] bArr, IWorkManagerImplCallback iWorkManagerImplCallback) throws RemoteException {
        }
    }
}
