package ab;

import ab.h;
import ga.e0;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: OptionalConverterFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@IgnoreJRERequirement
final class r extends h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final h.a f463a = new r();

    /* JADX INFO: compiled from: OptionalConverterFactory.java */
    @IgnoreJRERequirement
    static final class a<T> implements h<e0, Optional<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h<e0, T> f464a;

        a(h<e0, T> hVar) {
            this.f464a = hVar;
        }

        @Override // ab.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Optional<T> convert(e0 e0Var) throws IOException {
            return Optional.ofNullable(this.f464a.convert(e0Var));
        }
    }

    r() {
    }

    @Override // ab.h.a
    public h<e0, ?> d(Type type, Annotation[] annotationArr, z zVar) {
        if (h.a.b(type) != Optional.class) {
            return null;
        }
        return new a(zVar.h(h.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
