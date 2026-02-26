package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements v8.l<VM> {

    @Nullable
    private VM cached;

    @NotNull
    private final h9.a<CreationExtras> extrasProducer;

    @NotNull
    private final h9.a<ViewModelProvider.Factory> factoryProducer;

    @NotNull
    private final h9.a<ViewModelStore> storeProducer;

    @NotNull
    private final KClass<VM> viewModelClass;

    /* JADX INFO: renamed from: androidx.lifecycle.ViewModelLazy$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewModelLazy.kt */
    static final class AnonymousClass1 extends v implements h9.a<CreationExtras.Empty> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final CreationExtras.Empty invoke() {
            return CreationExtras.Empty.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(@NotNull KClass<VM> viewModelClass, @NotNull h9.a<? extends ViewModelStore> storeProducer, @NotNull h9.a<? extends ViewModelProvider.Factory> factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        t.i(viewModelClass, "viewModelClass");
        t.i(storeProducer, "storeProducer");
        t.i(factoryProducer, "factoryProducer");
    }

    @Override // v8.l
    public boolean isInitialized() {
        return this.cached != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(@NotNull KClass<VM> viewModelClass, @NotNull h9.a<? extends ViewModelStore> storeProducer, @NotNull h9.a<? extends ViewModelProvider.Factory> factoryProducer, @NotNull h9.a<? extends CreationExtras> extrasProducer) {
        t.i(viewModelClass, "viewModelClass");
        t.i(storeProducer, "storeProducer");
        t.i(factoryProducer, "factoryProducer");
        t.i(extrasProducer, "extrasProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
        this.extrasProducer = extrasProducer;
    }

    @Override // v8.l
    @NotNull
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke(), this.extrasProducer.invoke()).get(g9.a.a(this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }

    public /* synthetic */ ViewModelLazy(KClass kClass, h9.a aVar, h9.a aVar2, h9.a aVar3, int i10, kotlin.jvm.internal.k kVar) {
        this(kClass, aVar, aVar2, (i10 & 8) != 0 ? AnonymousClass1.INSTANCE : aVar3);
    }
}
