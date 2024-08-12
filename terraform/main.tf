terraform {
    required_version = ">= 1.9.4"
    required_providers {
      aws = {
        source = "hashicorp/aws"
        version = ">= 5.61.0"
      }
    }
}

variable "aws_region" {
  type = string
  description = "The AWS region to deploy resources."
  default = "us-west-2"
}

provider "aws" {
  region = var.aws_region
}