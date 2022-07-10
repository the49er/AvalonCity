<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
                <title>Register form</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        </head>
        <body>
            <table border="0">
                <form action="register" method="post">
                   <div class="form-row">
                       <div class="col-md-4 mb-3">
                         <label for="validationTooltip01">First name</label>
                         <input type="text" class="form-control" id="validationTooltip01" placeholder="First name" name="firstName" required>
                         <div class="valid-tooltip">
                           Looks good!
                         </div>
                       </div>
                       <div class="col-md-4 mb-3">
                         <label for="validationTooltip02">Last name</label>
                         <input type="text" class="form-control" id="validationTooltip02" placeholder="Last name" name="lastName" required>
                         <div class="valid-tooltip">
                           Looks good!
                         </div>
                       </div>
                       <div class="col-md-4 mb-3">
                         <label for="validationTooltipUsername">Username</label>
                         <div class="input-group">
                           <div class="input-group-prepend">
                             <span class="input-group-text" id="validationTooltipUsernamePrepend">@</span>
                           </div>
                           <input type="text" class="form-control" id="validationTooltipUsername" placeholder="Username" aria-describedby="validationTooltipUsernamePrepend" name="email" required>
                           <div class="invalid-tooltip">
                             Please choose a unique and valid username.
                           </div>
                         </div>
                       </div>
                     </div>
                     <div class="form-row">
                       <div class="col-md-6 mb-3">
                         <label for="validationTooltip03">City</label>
                         <input type="text" class="form-control" id="validationTooltip03" placeholder="City" required>
                         <div class="invalid-tooltip">
                           Please provide a valid city.
                         </div>
                       </div>
                       <div class="col-md-3 mb-3">
                         <label for="validationTooltip04">State</label>
                         <input type="text" class="form-control" id="validationTooltip04" placeholder="State" required>
                         <div class="invalid-tooltip">
                           Please provide a valid state.
                         </div>
                       </div>
                       <div class="col-md-3 mb-3">
                         <label for="validationTooltip05">Zip</label>
                         <input type="text" class="form-control" id="validationTooltip05" placeholder="Zip" required>
                         <div class="invalid-tooltip">
                           Please provide a valid zip.
                         </div>
                       </div>
                     </div>
                     <button class="btn btn-primary" type="submit">Submit form</button>
                </form>
            </table>
        </body>
</html>