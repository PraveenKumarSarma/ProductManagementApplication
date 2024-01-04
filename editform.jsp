<!DOCTYPE html>
<html>
<head>
<title>Add product</title>
<!-- Bootstrap CDN link to Get the Support of BootStrap-->
<link rel="stylesheet" 
href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<!-- This is java script validation code Location -->

<script src="formValidation.js" ></script>
</head>
<body bgcolor="orange">

<div class="container mt-5 text-center">
<h2 class="text-center font-italic mb-1">Save Product Data...</h2>
<form method="post" action="./UpdateServlet" enctype="multipart/form-data" 
onsubmit="return validateform()">


<div class="form-group">
<label class="font-italic font-weight-bold" for="prodId">Product Id:</label>
<input type="text" class="form-control-sm" id=prodId name="prodId" value="${existingProduct.prodId }" required/>
</div>

<div class="form_group">
<label class="font-italic font-weight-bold" for="proName">Product Name:</label>
<input type="text" class="form-control-sm" id="proName" name="proName" value="${existingProduct.proName }" required/>
</div>

<div class="form-group">
<label class="font-italic font-weight-bold" for="proPrice">Product Price:</label>
<input type="number" class="form-control-sm" id="proPrice" name="proPrice" value="${existingProduct.proPrice }" required/>
</div>



<div class="form-group">
<label class="font-italic font-weight-bold" for="proBrand" >Product Brand:</label>
<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingProduct.proBrand }" required/>
</div>


<div class="form-group">
<label class="font-italic font-weight-bold" for="proMadeIn" >MadeIn:</label>
<input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingProduct.proMadeIn }"required/>
</div>


<div class="form-group">
<label class="font-italic font-weight-bold" for="proMfgDate" >Manufacturing Date:</label>
<input type="date" class="form-control-sm" id="proMfgDate" name="proMfgDate" value="${existingProduct.proMfgDate }" required/>
</div>


<div class="form-group">
<label class="font-italic font-weight-bold" for="proExpDate" >Expiry date:</label>
<input type="date" class="form-control-sm" id="proExpDate" name="proExpDate" value="${existingProduct.proExpDate}" required/>
</div>

<div class="form-group">
<label class="font-italic font-weight-bold" for="proImage" >Product Image:</label>
<input type="file" class="form-control-sm" id="proImage" name="proImage" value="${existingProduct.proImage}" accept="image/*" />
</div>


<div>
<input type="submit" class="btn btn-success" value="update product"/>
<a href="listprod.jsp" class="btn btn-primary">list of Products</a>

</div>

</form>
</div>
</body>
</html>