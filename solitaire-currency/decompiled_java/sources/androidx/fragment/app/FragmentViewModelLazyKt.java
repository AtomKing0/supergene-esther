package androidx.fragment.app;

import androidx.annotation.MainThread;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.o0;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewModelLazyKt {

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$1, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.v implements h9.a<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
            kotlin.jvm.internal.t.h(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$2, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass2 extends kotlin.jvm.internal.v implements h9.a<CreationExtras> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.t.h(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$3, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass3 extends kotlin.jvm.internal.v implements h9.a<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.t.h(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$4, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass4 extends kotlin.jvm.internal.v implements h9.a<ViewModelStore> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
            kotlin.jvm.internal.t.h(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$5, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass5 extends kotlin.jvm.internal.v implements h9.a<CreationExtras> {
        final /* synthetic */ h9.a<CreationExtras> $extrasProducer;
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass5(h9.a<? extends CreationExtras> aVar, Fragment fragment) {
            super(0);
            this.$extrasProducer = aVar;
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            h9.a<CreationExtras> aVar = this.$extrasProducer;
            if (aVar != null && (creationExtrasInvoke = aVar.invoke()) != null) {
                return creationExtrasInvoke;
            }
            CreationExtras defaultViewModelCreationExtras = this.$this_activityViewModels.requireActivity().getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.t.h(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$activityViewModels$6, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass6 extends kotlin.jvm.internal.v implements h9.a<ViewModelProvider.Factory> {
        final /* synthetic */ Fragment $this_activityViewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Fragment fragment) {
            super(0);
            this.$this_activityViewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.t.h(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    static final class C10331 extends kotlin.jvm.internal.v implements h9.a<CreationExtras> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10331(Fragment fragment) {
            super(0);
            this.$this_createViewModelLazy = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras = this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.t.h(defaultViewModelCreationExtras, "defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    static final class C10342 extends kotlin.jvm.internal.v implements h9.a<CreationExtras> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10342(Fragment fragment) {
            super(0);
            this.$this_createViewModelLazy = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras = this.$this_createViewModelLazy.getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.t.h(defaultViewModelCreationExtras, "defaultViewModelCreationExtras");
            return defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C10351 extends kotlin.jvm.internal.v implements h9.a<Fragment> {
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10351(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C10362 extends kotlin.jvm.internal.v implements h9.a<ViewModelStore> {
        final /* synthetic */ v8.l<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10362(v8.l<? extends ViewModelStoreOwner> lVar) {
            super(0);
            this.$owner$delegate = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m3930viewModels$lambda0(this.$owner$delegate).getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C10373 extends kotlin.jvm.internal.v implements h9.a<CreationExtras> {
        final /* synthetic */ v8.l<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10373(v8.l<? extends ViewModelStoreOwner> lVar) {
            super(0);
            this.$owner$delegate = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras defaultViewModelCreationExtras;
            ViewModelStoreOwner viewModelStoreOwnerM3930viewModels$lambda0 = FragmentViewModelLazyKt.m3930viewModels$lambda0(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3930viewModels$lambda0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3930viewModels$lambda0 : null;
            return (hasDefaultViewModelProviderFactory == null || (defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras()) == null) ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C10384 extends kotlin.jvm.internal.v implements h9.a<ViewModelProvider.Factory> {
        final /* synthetic */ v8.l<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10384(Fragment fragment, v8.l<? extends ViewModelStoreOwner> lVar) {
            super(0);
            this.$this_viewModels = fragment;
            this.$owner$delegate = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM3930viewModels$lambda0 = FragmentViewModelLazyKt.m3930viewModels$lambda0(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3930viewModels$lambda0 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3930viewModels$lambda0 : null;
            if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                return defaultViewModelProviderFactory;
            }
            ViewModelProvider.Factory defaultViewModelProviderFactory2 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.t.h(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory2;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C10395 extends kotlin.jvm.internal.v implements h9.a<Fragment> {
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10395(Fragment fragment) {
            super(0);
            this.$this_viewModels = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Fragment invoke() {
            return this.$this_viewModels;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$6, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class C10406 extends kotlin.jvm.internal.v implements h9.a<ViewModelStore> {
        final /* synthetic */ v8.l<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C10406(v8.l<? extends ViewModelStoreOwner> lVar) {
            super(0);
            this.$owner$delegate = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.m3931viewModels$lambda1(this.$owner$delegate).getViewModelStore();
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$7, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass7 extends kotlin.jvm.internal.v implements h9.a<CreationExtras> {
        final /* synthetic */ h9.a<CreationExtras> $extrasProducer;
        final /* synthetic */ v8.l<ViewModelStoreOwner> $owner$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(h9.a<? extends CreationExtras> aVar, v8.l<? extends ViewModelStoreOwner> lVar) {
            super(0);
            this.$extrasProducer = aVar;
            this.$owner$delegate = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final CreationExtras invoke() {
            CreationExtras creationExtrasInvoke;
            h9.a<CreationExtras> aVar = this.$extrasProducer;
            if (aVar != null && (creationExtrasInvoke = aVar.invoke()) != null) {
                return creationExtrasInvoke;
            }
            ViewModelStoreOwner viewModelStoreOwnerM3931viewModels$lambda1 = FragmentViewModelLazyKt.m3931viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3931viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3931viewModels$lambda1 : null;
            return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$8, reason: invalid class name */
    /* JADX INFO: compiled from: FragmentViewModelLazy.kt */
    public static final class AnonymousClass8 extends kotlin.jvm.internal.v implements h9.a<ViewModelProvider.Factory> {
        final /* synthetic */ v8.l<ViewModelStoreOwner> $owner$delegate;
        final /* synthetic */ Fragment $this_viewModels;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Fragment fragment, v8.l<? extends ViewModelStoreOwner> lVar) {
            super(0);
            this.$this_viewModels = fragment;
            this.$owner$delegate = lVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            ViewModelStoreOwner viewModelStoreOwnerM3931viewModels$lambda1 = FragmentViewModelLazyKt.m3931viewModels$lambda1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM3931viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM3931viewModels$lambda1 : null;
            if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                return defaultViewModelProviderFactory;
            }
            ViewModelProvider.Factory defaultViewModelProviderFactory2 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.t.h(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory2;
        }
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> v8.l<VM> activityViewModels(Fragment fragment, h9.a<? extends ViewModelProvider.Factory> aVar) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.o(4, "VM");
        KClass kClassB = o0.b(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(fragment);
        if (aVar == null) {
            aVar = new AnonymousClass3(fragment);
        }
        return createViewModelLazy(fragment, kClassB, anonymousClass1, anonymousClass2, aVar);
    }

    public static /* synthetic */ v8.l activityViewModels$default(Fragment fragment, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.o(4, "VM");
        KClass kClassB = o0.b(ViewModel.class);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(fragment);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(fragment);
        if (aVar == null) {
            aVar = new AnonymousClass3(fragment);
        }
        return createViewModelLazy(fragment, kClassB, anonymousClass1, anonymousClass2, aVar);
    }

    @MainThread
    public static final /* synthetic */ v8.l createViewModelLazy(Fragment fragment, KClass viewModelClass, h9.a storeProducer, h9.a aVar) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.t.i(storeProducer, "storeProducer");
        return createViewModelLazy(fragment, viewModelClass, storeProducer, new C10331(fragment), aVar);
    }

    public static /* synthetic */ v8.l createViewModelLazy$default(Fragment fragment, KClass kClass, h9.a aVar, h9.a aVar2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar2 = null;
        }
        return createViewModelLazy(fragment, kClass, aVar, aVar2);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> v8.l<VM> viewModels(Fragment fragment, h9.a<? extends ViewModelStoreOwner> ownerProducer, h9.a<? extends ViewModelProvider.Factory> aVar) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(ownerProducer, "ownerProducer");
        v8.l lVarB = v8.n.b(v8.p.f35203c, new FragmentViewModelLazyKt$viewModels$owner$2(ownerProducer));
        kotlin.jvm.internal.t.o(4, "VM");
        KClass kClassB = o0.b(ViewModel.class);
        C10362 c10362 = new C10362(lVarB);
        C10373 c10373 = new C10373(lVarB);
        if (aVar == null) {
            aVar = new C10384(fragment, lVarB);
        }
        return createViewModelLazy(fragment, kClassB, c10362, c10373, aVar);
    }

    public static /* synthetic */ v8.l viewModels$default(Fragment fragment, h9.a ownerProducer, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ownerProducer = new C10351(fragment);
        }
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(ownerProducer, "ownerProducer");
        v8.l lVarB = v8.n.b(v8.p.f35203c, new FragmentViewModelLazyKt$viewModels$owner$2(ownerProducer));
        kotlin.jvm.internal.t.o(4, "VM");
        KClass kClassB = o0.b(ViewModel.class);
        C10362 c10362 = new C10362(lVarB);
        C10373 c10373 = new C10373(lVarB);
        if (aVar == null) {
            aVar = new C10384(fragment, lVarB);
        }
        return createViewModelLazy(fragment, kClassB, c10362, c10373, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: viewModels$lambda-0, reason: not valid java name */
    public static final ViewModelStoreOwner m3930viewModels$lambda0(v8.l<? extends ViewModelStoreOwner> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: viewModels$lambda-1, reason: not valid java name */
    public static final ViewModelStoreOwner m3931viewModels$lambda1(v8.l<? extends ViewModelStoreOwner> lVar) {
        return lVar.getValue();
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> v8.l<VM> activityViewModels(Fragment fragment, h9.a<? extends CreationExtras> aVar, h9.a<? extends ViewModelProvider.Factory> aVar2) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.o(4, "VM");
        KClass kClassB = o0.b(ViewModel.class);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(fragment);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(aVar, fragment);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass6(fragment);
        }
        return createViewModelLazy(fragment, kClassB, anonymousClass4, anonymousClass5, aVar2);
    }

    @MainThread
    @NotNull
    public static final <VM extends ViewModel> v8.l<VM> createViewModelLazy(@NotNull Fragment fragment, @NotNull KClass<VM> viewModelClass, @NotNull h9.a<? extends ViewModelStore> storeProducer, @NotNull h9.a<? extends CreationExtras> extrasProducer, @Nullable h9.a<? extends ViewModelProvider.Factory> aVar) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.t.i(storeProducer, "storeProducer");
        kotlin.jvm.internal.t.i(extrasProducer, "extrasProducer");
        if (aVar == null) {
            aVar = new FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1(fragment);
        }
        return new ViewModelLazy(viewModelClass, storeProducer, aVar, extrasProducer);
    }

    public static /* synthetic */ v8.l createViewModelLazy$default(Fragment fragment, KClass kClass, h9.a aVar, h9.a aVar2, h9.a aVar3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            aVar2 = new C10342(fragment);
        }
        if ((i10 & 8) != 0) {
            aVar3 = null;
        }
        return createViewModelLazy(fragment, kClass, aVar, aVar2, aVar3);
    }

    public static /* synthetic */ v8.l activityViewModels$default(Fragment fragment, h9.a aVar, h9.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        if ((i10 & 2) != 0) {
            aVar2 = null;
        }
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.o(4, "VM");
        KClass kClassB = o0.b(ViewModel.class);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(fragment);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(aVar, fragment);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass6(fragment);
        }
        return createViewModelLazy(fragment, kClassB, anonymousClass4, anonymousClass5, aVar2);
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> v8.l<VM> viewModels(Fragment fragment, h9.a<? extends ViewModelStoreOwner> ownerProducer, h9.a<? extends CreationExtras> aVar, h9.a<? extends ViewModelProvider.Factory> aVar2) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(ownerProducer, "ownerProducer");
        v8.l lVarB = v8.n.b(v8.p.f35203c, new FragmentViewModelLazyKt$viewModels$owner$4(ownerProducer));
        kotlin.jvm.internal.t.o(4, "VM");
        KClass kClassB = o0.b(ViewModel.class);
        C10406 c10406 = new C10406(lVarB);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(aVar, lVarB);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass8(fragment, lVarB);
        }
        return createViewModelLazy(fragment, kClassB, c10406, anonymousClass7, aVar2);
    }

    public static /* synthetic */ v8.l viewModels$default(Fragment fragment, h9.a ownerProducer, h9.a aVar, h9.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ownerProducer = new C10395(fragment);
        }
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        if ((i10 & 4) != 0) {
            aVar2 = null;
        }
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(ownerProducer, "ownerProducer");
        v8.l lVarB = v8.n.b(v8.p.f35203c, new FragmentViewModelLazyKt$viewModels$owner$4(ownerProducer));
        kotlin.jvm.internal.t.o(4, "VM");
        KClass kClassB = o0.b(ViewModel.class);
        C10406 c10406 = new C10406(lVarB);
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(aVar, lVarB);
        if (aVar2 == null) {
            aVar2 = new AnonymousClass8(fragment, lVarB);
        }
        return createViewModelLazy(fragment, kClassB, c10406, anonymousClass7, aVar2);
    }
}
