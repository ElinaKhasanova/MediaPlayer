<%@attribute name="email" required="true" %>

<label for="inputEmail">E-mail</label>
<input type="text" id="inputEmail" name="email"
       placeholder="<%if(email == null){out.write("Логин");}
       else out.write(email);%>"
       height="10" width="20">