<!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
                <title>Register form</title>
                <style>
                    body {
                        margin: 0;
                        background-color: hsl(0, 0%, 98%);
                        color: #333;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        font: 100% / normal sans-serif;
                    }

                    main {
                        margin: 0 auto;
                        padding: 2rem 0;
                        width: 90%;
                        max-width: 20rem;
                    }

                    form {
                        box-sizing: border-box;
                        padding: 1.5rem;
                        border-radius: 1rem;
                        background-color: hsl(0, 0%, 100%);
                        border: 4px solid hsl(0, 0%, 90%);
                        display: flex;
                        flex-direction: column;
                    }

                    label {
                        margin-bottom: 0.5rem;

                        font-weight: 700;
                        text-transform: uppercase;
                    }
                    input, select {
                        margin-bottom: 1rem;
                    }

                    button {
                        width: 6rem;
                        padding: 0.5rem;

                        text-transform: uppercase;
                        font-weight: 700;
                        background-color: hsl(213, 73%, 50%);
                        color: white;
                        border-radius: 0.25rem;
                        border: none;
                        cursor: pointer;
                    }
                </style>
        </head>
        <body>
            <main>
            <form action="ace-park" method="post">
                <label for="email">E-mail Address:</label>
                <input type="email" id="email" name="email" placeholder="E-mail Address"  required maxlength="255">
                <label for="title">Title:</label>
                <select id="title" name="title" required>
                    <option disabled selected value="">Select title</option>
                    <option>Mr</option>
                    <option>Mrs</option>
                    <option>Ms</option>
                    <option>Other</option>
                </select>
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" placeholder="First Name" required maxlength="50">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" placeholder="Last Name" required maxlength="50">
                <label for="adress1">Address line 1:</label>
                <input type="text" id="address1" name="addressLine1" placeholder="Address line 1" required maxlength="255">
                <label for="adress2">Address line 2:</label>
                <input type="text" id="address2" name="addressLine2" placeholder="Address line 2" maxlength="255">
                <label for="city">City:</label>
                <input type="text" id="city" name="city" placeholder="City" maxlength="255">
                <label for="postcode">Postcode:</label>
                <input type="text" id="postcode" name="postcode" placeholder="Postcode" required maxlength="10">
                <label for="phone">Telephone number:</label>
                <input type="text" id="phone" name="telNumber" placeholder="Telephone number" maxlength="20">
ace-park
                <button type="submit" value="">Register</button>
            </form>
        </main>


        </body>
</html>