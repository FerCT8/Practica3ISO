package StaticView.Dominio;

public class Empleados {

	private int Login;
	private int Password;
	private int DNI;
	private int Nombre;
	private int Apellidos;
	private int Telefono;
	private int Permiso;

	public int getLogin() {
		return this.Login;
	}

	public void setLogin(int Login) {
		this.Login = Login;
	}

	public int getPassword() {
		return this.Password;
	}

	public void setPassword(int Password) {
		this.Password = Password;
	}

	public int getDNI() {
		return this.DNI;
	}

	public void setDNI(int DNI) {
		this.DNI = DNI;
	}

	public int getNombre() {
		return this.Nombre;
	}

	public void setNombre(int Nombre) {
		this.Nombre = Nombre;
	}

	public int getApellidos() {
		return this.Apellidos;
	}

	public void setApellidos(int Apellidos) {
		this.Apellidos = Apellidos;
	}

	public int getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(int Telefono) {
		this.Telefono = Telefono;
	}

	public int getPermiso() {
		return this.Permiso;
	}

	public void setPermiso(int Permiso) {
		this.Permiso = Permiso;
	}

}