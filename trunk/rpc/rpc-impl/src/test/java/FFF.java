import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class FFF {
	public static void main(String[] args) throws Exception {
		
		final Foo target = new Foo() {

			@Override
			public void m1(int args0, int args1) {
				System.out.println("mmmmmmmmmmmm11111111111, args0:" + args0 + ", args1:" + args1);
			}
			@Override
			public int m2(String args0, String args1) {
				System.out.println("mmmmmmmmmmmm1222222222222, args0:" + args0 + ", args1:" + args1);
				return 1233;
			}
			
		};
		
		InvocationHandler handler = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				System.out.println("invoke method:" + method + ", args:" + Arrays.asList(args));
				
				return method.invoke(target, args);
			}
		};

		Class<?> proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(),
				new Class[] { Foo.class });
		Foo f = (Foo) proxyClass.getConstructor(
				new Class[] { InvocationHandler.class }).newInstance(
				new Object[] { handler });

		Foo f2 = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
				new Class[] { Foo.class }, handler);

		
		f.m1(1, 2);
		f2.m1(1, 2);
		f.m2("abc", "def");
	}
}
