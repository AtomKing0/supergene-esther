package com.unity3d.services.core.domain.task;

import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import z8.d;

/* JADX INFO: compiled from: InitializeSDK.kt */
/* JADX INFO: loaded from: classes4.dex */
@f(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", f = "InitializeSDK.kt", l = {44, 49, 51, 56, 58, 62, 65, 80, 83, 91, 94, 97}, m = "invokeSuspend")
final class InitializeSDK$doWork$2 extends l implements p<o0, d<? super t<? extends k0>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2(InitializeSDK initializeSDK, d<? super InitializeSDK$doWork$2> dVar) {
        super(2, dVar);
        this.this$0 = initializeSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this.this$0, dVar);
        initializeSDK$doWork$2.L$0 = obj;
        return initializeSDK$doWork$2;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(o0 o0Var, d<? super t<? extends k0>> dVar) {
        return invoke2(o0Var, (d<? super t<k0>>) dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x026d A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02bc A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02eb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011d A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0163 A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0180 A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018c A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ab A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e8 A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0207 A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0213 A[Catch: all -> 0x0302, CancellationException -> 0x032b, TryCatch #2 {CancellationException -> 0x032b, all -> 0x0302, blocks: (B:6:0x0012, B:118:0x02ec, B:9:0x0023, B:115:0x02cf, B:12:0x002e, B:110:0x02b6, B:112:0x02bc, B:15:0x0041, B:103:0x0282, B:106:0x0292, B:18:0x004c, B:98:0x0267, B:100:0x026d, B:22:0x005c, B:84:0x0201, B:86:0x0207, B:87:0x0212, B:25:0x0074, B:78:0x01e2, B:80:0x01e8, B:88:0x0213, B:90:0x021e, B:92:0x0228, B:94:0x022e, B:95:0x0245, B:104:0x028c, B:119:0x02f6, B:120:0x0301, B:28:0x008d, B:75:0x01c1, B:31:0x009e, B:70:0x01a5, B:72:0x01ab, B:34:0x00ae, B:63:0x017a, B:65:0x0180, B:66:0x018b, B:37:0x00c4, B:57:0x015d, B:59:0x0163, B:67:0x018c, B:40:0x00d7, B:48:0x0117, B:50:0x011d, B:51:0x0135, B:54:0x0141, B:44:0x00ec), top: B:133:0x0007 }] */
    @Override // kotlin.coroutines.jvm.internal.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull o0 o0Var, @Nullable d<? super t<k0>> dVar) {
        return ((InitializeSDK$doWork$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
