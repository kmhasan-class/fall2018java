public class HelloWorld {
	public static void main(String args[]) {
		int i;

		System.out.printf("%d\n", args.length);

		for (i = 0; i < args.length; i++)
			System.out.printf("%d %s\n", i, args[i]);

		System.out.printf("Hello World\n");
	}
}
