# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# NO CHECKED-IN PROTOBUF GENCODE
# source: product.proto
# Protobuf Python Version: 5.27.2
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import runtime_version as _runtime_version
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
_runtime_version.ValidateProtobufRuntimeVersion(
    _runtime_version.Domain.PUBLIC,
    5,
    27,
    2,
    '',
    'product.proto'
)
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\rproduct.proto\x12\x13\x63om.unla.stockearte\"r\n\x07Product\x12\n\n\x02id\x18\x01 \x01(\x04\x12\x0e\n\x06nombre\x18\x02 \x01(\t\x12\r\n\x05talle\x18\x03 \x01(\t\x12\x0c\n\x04\x66oto\x18\x04 \x01(\t\x12\r\n\x05\x63olor\x18\x05 \x01(\t\x12\r\n\x05stock\x18\x06 \x01(\x05\x12\x10\n\x08idTienda\x18\x07 \x03(\x04\"(\n\x15\x43reateProductResponse\x12\x0f\n\x07success\x18\x01 \x01(\x08\"&\n\x13\x45\x64itProductResponse\x12\x0f\n\x07success\x18\x01 \x01(\x08\"(\n\x15\x44\x65leteProductResponse\x12\x0f\n\x07success\x18\x01 \x01(\x08\"\"\n\x14\x44\x65leteProductRequest\x12\n\n\x02id\x18\x01 \x01(\x05\"Z\n\x14\x46ilterProductRequest\x12\x0e\n\x06nombre\x18\x01 \x01(\t\x12\x14\n\x0c\x63odigo_unico\x18\x02 \x01(\t\x12\r\n\x05talle\x18\x03 \x01(\t\x12\r\n\x05\x63olor\x18\x04 \x01(\t\"F\n\x15\x46ilterProductResponse\x12-\n\x07product\x18\x01 \x03(\x0b\x32\x1c.com.unla.stockearte.Product\";\n\x11GetProductRequest\x12\x14\n\x0ctipo_usuario\x18\x01 \x01(\t\x12\x10\n\x08idTienda\x18\x02 \x01(\t\"C\n\x12GetProductResponse\x12-\n\x07product\x18\x01 \x03(\x0b\x32\x1c.com.unla.stockearte.Product\"\x86\x01\n\x17GetDetailProductRequest\x12\n\n\x02id\x18\x01 \x01(\x04\x12\x14\n\x0ctipo_usuario\x18\x02 \x01(\t\x12\r\n\x05stock\x18\x03 \x01(\x05\x12\x0e\n\x06nombre\x18\x04 \x01(\t\x12\r\n\x05talle\x18\x05 \x01(\t\x12\x0c\n\x04\x66oto\x18\x06 \x01(\t\x12\r\n\x05\x63olor\x18\x07 \x01(\t\"I\n\x18GetDetailProductResponse\x12-\n\x07product\x18\x01 \x01(\x0b\x32\x1c.com.unla.stockearte.Product2\x83\x04\n\x0eProductService\x12Y\n\rCreateProduct\x12\x1c.com.unla.stockearte.Product\x1a*.com.unla.stockearte.CreateProductResponse\x12U\n\x0b\x45\x64itProduct\x12\x1c.com.unla.stockearte.Product\x1a(.com.unla.stockearte.EditProductResponse\x12\x66\n\rDeleteProduct\x12).com.unla.stockearte.DeleteProductRequest\x1a*.com.unla.stockearte.DeleteProductResponse\x12\x66\n\rFilterProduct\x12).com.unla.stockearte.FilterProductRequest\x1a*.com.unla.stockearte.FilterProductResponse\x12o\n\x10GetDetailProduct\x12,.com.unla.stockearte.GetDetailProductRequest\x1a-.com.unla.stockearte.GetDetailProductResponseB,\n\x13\x63om.unla.stockearteB\x13ProductServiceProtoP\x01\x62\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'product_pb2', _globals)
if not _descriptor._USE_C_DESCRIPTORS:
  _globals['DESCRIPTOR']._loaded_options = None
  _globals['DESCRIPTOR']._serialized_options = b'\n\023com.unla.stockearteB\023ProductServiceProtoP\001'
  _globals['_PRODUCT']._serialized_start=38
  _globals['_PRODUCT']._serialized_end=152
  _globals['_CREATEPRODUCTRESPONSE']._serialized_start=154
  _globals['_CREATEPRODUCTRESPONSE']._serialized_end=194
  _globals['_EDITPRODUCTRESPONSE']._serialized_start=196
  _globals['_EDITPRODUCTRESPONSE']._serialized_end=234
  _globals['_DELETEPRODUCTRESPONSE']._serialized_start=236
  _globals['_DELETEPRODUCTRESPONSE']._serialized_end=276
  _globals['_DELETEPRODUCTREQUEST']._serialized_start=278
  _globals['_DELETEPRODUCTREQUEST']._serialized_end=312
  _globals['_FILTERPRODUCTREQUEST']._serialized_start=314
  _globals['_FILTERPRODUCTREQUEST']._serialized_end=404
  _globals['_FILTERPRODUCTRESPONSE']._serialized_start=406
  _globals['_FILTERPRODUCTRESPONSE']._serialized_end=476
  _globals['_GETPRODUCTREQUEST']._serialized_start=478
  _globals['_GETPRODUCTREQUEST']._serialized_end=537
  _globals['_GETPRODUCTRESPONSE']._serialized_start=539
  _globals['_GETPRODUCTRESPONSE']._serialized_end=606
  _globals['_GETDETAILPRODUCTREQUEST']._serialized_start=609
  _globals['_GETDETAILPRODUCTREQUEST']._serialized_end=743
  _globals['_GETDETAILPRODUCTRESPONSE']._serialized_start=745
  _globals['_GETDETAILPRODUCTRESPONSE']._serialized_end=818
  _globals['_PRODUCTSERVICE']._serialized_start=821
  _globals['_PRODUCTSERVICE']._serialized_end=1336
# @@protoc_insertion_point(module_scope)
