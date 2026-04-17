# SheredPreference 

```java

SharedPreferences sheredPref = getSharedPreferences("Mis ajustes", Context.MODE_PRIVATE);
SharedPreferences.Editor edit = sheredPref.edit();

edit.putString("TOKEN", "123");
edit.apply();

mensaje.setText(sheredPref.getString("TOKEN", "No se encontro"));
```