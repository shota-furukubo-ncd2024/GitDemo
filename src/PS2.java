
public class PS2 extends PS3{

	int b;

	public PS2(int a) {
		super(a);
		this.b=a;//this.はこのクラスの変数ということ
	}

	public int increment() {

		b = b + 1;
		return b;

	}

	public int decrement() {

		b = b - 1;
		return b;

	}

}
