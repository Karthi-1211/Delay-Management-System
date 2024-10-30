<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .dashboardimage{
            background-color: whitesmoke;
        }
        body {
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            margin: 0; /* Remove default body margin for top bar positioning */
        }
        .top-bar {
            display: flex; /* Make top bar a flex container */
            justify-content: space-between; /* Space out content horizontally */
            align-items: center; /* Align content vertically */
            background-color: #f0f0f0; /* Set background color */
            padding: 10px 20px; /* Add padding */
            height: 140px; /* Set increased height for top bar */
            position: fixed; /* Fix top bar to top of viewport */
            top: 0; /* Set top position to 0 */
            width: 100%; /* Set width to 100% for full page */
            z-index: 10; /* Ensure top bar stays on top of other elements */
            border-bottom: 3px solid black; /* Add border at the bottom */
            background-color:#7d7979;
        }
        .top-bar h1 {
            margin: 0; /* Remove default margin from heading */
            text-align: center; /* Center the title */
            font-size: 60px;
            white-space: nowrap; /* Prevent text from wrapping */
            overflow: hidden; /* Hide overflow */
            text-overflow: ellipsis; /* Display ellipsis (...) if text overflows */
            flex: 1; /* Allow title to take up remaining space */
            margin-left: 110px;
            margin-right:30px;
            font-family:Times New Roman;
            color:black;
        }
        .top-bar .logout {
            margin-left: 50px; /* Push the logout button to the right */
            margin-right: 100px; /* Add margin to the right */
            margin-top: 10px;
        }
        .top-bar .logout a {
            text-decoration: none;
            padding: 10px 20px;
            background-color: #d9534f;
            color: white;
            border: none;
            border-radius: 5px;
        }
        .top-bar .logo {
            display: flex;
            align-items: center;
        }
        .top-bar .logo img {
            width: 130px; /* Adjust width of the icon image */
            margin-right: 10px; /* Add margin to separate from text */
        }
        
        .dashboard-image {
    position: fixed; /* Keep the image fixed */
    top: 140px; /* Position it below the top bar */
    left: 50%; /* Center horizontally */
    transform: translateX(-30%); /* Center the image */
    width: calc(100% - 60px); /* Make it responsive to the viewport width */
    max-width: 800px; /* Set maximum width */
    height: auto; /* Maintain aspect ratio */
    border-radius: 10px; /* Add border radius */
    z-index: 5; /* Ensure it stays above other content */
}

        .menu-container {
            display: flex;
            width: 100%;
            margin-top: 130px; /* Adjust margin to position below the top bar */
        }
        .menu {
            margin-top: 20px;
            width: 22%;
            background-color:black;
            padding: 30px;
            box-sizing: border-box;
            height: calc(100vh - 120px); /* Adjust height to fill the remaining space */
            position: fixed; /* Fix menu to side of page */
            top: 120px; /* Position below the top bar */
            z-index: 5; /* Ensure menu stays below the top bar */
            border-right: 3px solid black; /* Add border to the right */
            border-bottom: 3px solid black; /* Add border at the bottom */
        }
        .menu h2 {
            text-align: center;
            color: white;
        }
        .menu button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            text-align: left;
            cursor: pointer;
        }
        .menu button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="top-bar">
    <div class="logo">
        <img src="https://thumbs.dreamstime.com/b/growing-graph-icon-growth-up-symbol-flat-vector-illustration-79862638.jpg" alt="Logo">
        <h1>DELAY MANAGEMENT SYSTEM</h1>
    </div>
    <div class="logout">
        Logged in as <%= request.getParameter("username") %> (<%= request.getParameter("email") %>)
        
        <a href="index.html">Logout</a>
    </div>
</div>
        <div class="dashboardimage" >
             <img src="Vizag.webp" alt="Dashboard Image" class="dashboard-image">
        </div>
<div class="menu">
    <center><h2>Menu Tree</h2></center>
    <a href="shop_wise_delays.html"><button>Shop Wise Delays</button></a>
    <a href="continued_delays.html"><button>Continued Delays</button></a>
    <a href="raw_material_delays.html"><button>Raw Material Delays</button></a>
    <a href="agency_delays.html"><button>Agency Delays</button></a>
</div>

<!-- Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>        