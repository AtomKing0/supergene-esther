package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: SafeWindowLayoutComponentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SafeWindowLayoutComponentProvider {

    @NotNull
    public static final SafeWindowLayoutComponentProvider INSTANCE = new SafeWindowLayoutComponentProvider();

    @NotNull
    private static final l windowLayoutComponent$delegate = n.a(SafeWindowLayoutComponentProvider$windowLayoutComponent$2.INSTANCE);

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1, reason: invalid class name */
    /* JADX INFO: compiled from: SafeWindowLayoutComponentProvider.kt */
    static final class AnonymousClass1 extends v implements h9.a<Boolean> {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() throws NoSuchMethodException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            Class clsFoldingFeatureClass = safeWindowLayoutComponentProvider.foldingFeatureClass(this.$classLoader);
            boolean z10 = false;
            Method getBoundsMethod = clsFoldingFeatureClass.getMethod("getBounds", new Class[0]);
            Method getTypeMethod = clsFoldingFeatureClass.getMethod("getType", new Class[0]);
            Method getStateMethod = clsFoldingFeatureClass.getMethod("getState", new Class[0]);
            t.h(getBoundsMethod, "getBoundsMethod");
            if (safeWindowLayoutComponentProvider.doesReturn(getBoundsMethod, (KClass<?>) o0.b(Rect.class)) && safeWindowLayoutComponentProvider.isPublic(getBoundsMethod)) {
                t.h(getTypeMethod, "getTypeMethod");
                Class cls = Integer.TYPE;
                if (safeWindowLayoutComponentProvider.doesReturn(getTypeMethod, (KClass<?>) o0.b(cls)) && safeWindowLayoutComponentProvider.isPublic(getTypeMethod)) {
                    t.h(getStateMethod, "getStateMethod");
                    if (safeWindowLayoutComponentProvider.doesReturn(getStateMethod, (KClass<?>) o0.b(cls)) && safeWindowLayoutComponentProvider.isPublic(getStateMethod)) {
                        z10 = true;
                    }
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeWindowLayoutComponentProvider.kt */
    static final class C10601 extends v implements h9.a<Boolean> {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10601(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() throws NoSuchMethodException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            boolean z10 = false;
            Method getWindowLayoutComponentMethod = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader).getMethod("getWindowLayoutComponent", new Class[0]);
            Class windowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
            t.h(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
            if (safeWindowLayoutComponentProvider.isPublic(getWindowLayoutComponentMethod)) {
                t.h(windowLayoutComponentClass, "windowLayoutComponentClass");
                if (safeWindowLayoutComponentProvider.doesReturn(getWindowLayoutComponentMethod, (Class<?>) windowLayoutComponentClass)) {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeWindowLayoutComponentProvider.kt */
    static final class C10611 extends v implements h9.a<Boolean> {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10611(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() throws NoSuchMethodException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            Class clsWindowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
            boolean z10 = false;
            Method addListenerMethod = clsWindowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", Activity.class, Consumer.class);
            Method removeListenerMethod = clsWindowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", Consumer.class);
            t.h(addListenerMethod, "addListenerMethod");
            if (safeWindowLayoutComponentProvider.isPublic(addListenerMethod)) {
                t.h(removeListenerMethod, "removeListenerMethod");
                if (safeWindowLayoutComponentProvider.isPublic(removeListenerMethod)) {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SafeWindowLayoutComponentProvider.kt */
    static final class C10621 extends v implements h9.a<Boolean> {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10621(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() throws NoSuchMethodException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            boolean z10 = false;
            Method getWindowExtensionsMethod = safeWindowLayoutComponentProvider.windowExtensionsProviderClass(this.$classLoader).getDeclaredMethod("getWindowExtensions", new Class[0]);
            Class windowExtensionsClass = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader);
            t.h(getWindowExtensionsMethod, "getWindowExtensionsMethod");
            t.h(windowExtensionsClass, "windowExtensionsClass");
            if (safeWindowLayoutComponentProvider.doesReturn(getWindowExtensionsMethod, (Class<?>) windowExtensionsClass) && safeWindowLayoutComponentProvider.isPublic(getWindowExtensionsMethod)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    private SafeWindowLayoutComponentProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canUseWindowLayoutComponent(ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 && isWindowLayoutProviderValid(classLoader) && isWindowExtensionsValid(classLoader) && isWindowLayoutComponentValid(classLoader) && isFoldingFeatureValid(classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, KClass<?> kClass) {
        return doesReturn(method, g9.a.a(kClass));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> foldingFeatureClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    private final boolean isFoldingFeatureValid(ClassLoader classLoader) {
        return validate(new AnonymousClass1(classLoader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPublic(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    private final boolean isWindowExtensionsValid(ClassLoader classLoader) {
        return validate(new C10601(classLoader));
    }

    @RequiresApi(24)
    private final boolean isWindowLayoutComponentValid(ClassLoader classLoader) {
        return validate(new C10611(classLoader));
    }

    private final boolean isWindowLayoutProviderValid(ClassLoader classLoader) {
        return validate(new C10621(classLoader));
    }

    private final boolean validate(h9.a<Boolean> aVar) {
        try {
            return aVar.invoke().booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowExtensionsClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowExtensionsProviderClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowLayoutComponentClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }

    @Nullable
    public final WindowLayoutComponent getWindowLayoutComponent() {
        return (WindowLayoutComponent) windowLayoutComponent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }
}
