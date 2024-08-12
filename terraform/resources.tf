resource "aws_lambda_function" "mypython_lambda" {
  function_name = "mypython_lambda_test"
  filename      = "mypython.zip"
  role          = aws_iam_role.my_lambda_role.arn
  handler       = "main.lambda_handler"
  runtime       = "python3.8"
  timeout       = 10
  memory_size   = 128
  
}

data "archive_file" "mypython_zip" {
  type        = "zip"
  source_dir  = "mypython.py"
  output_path = "mypython.zip"
}