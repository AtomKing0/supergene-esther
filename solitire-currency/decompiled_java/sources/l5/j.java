package l5;

import com.google.firebase.components.ComponentRegistrar;
import java.util.List;

/* JADX INFO: compiled from: ComponentRegistrarProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f30862a = new j() { // from class: l5.i
        @Override // l5.j
        public final List a(ComponentRegistrar componentRegistrar) {
            return componentRegistrar.getComponents();
        }
    };

    List<c<?>> a(ComponentRegistrar componentRegistrar);
}
