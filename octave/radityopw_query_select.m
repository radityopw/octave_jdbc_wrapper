## Copyright (C) 2016 radity
## 
## This program is free software; you can redistribute it and/or modify it
## under the terms of the GNU General Public License as published by
## the Free Software Foundation; either version 3 of the License, or
## (at your option) any later version.
## 
## This program is distributed in the hope that it will be useful,
## but WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
## 
## You should have received a copy of the GNU General Public License
## along with this program.  If not, see <http://www.gnu.org/licenses/>.

## Author: radityo <http://about.me/radityopw>
## Created: 2016-01-12

function retval = radityopw_query_select (sql)

  source("radityopw_query_init.m");
  
  wrapper = radityopw_query_connect(radityopw_query_driver,radityopw_query_url,radityopw_query_user,radityopw_query_password);
  execute_result = javaMethod("executeQuery",wrapper,sql);
  
  result_empty = javaMethod("isEmpty",execute_result);
  result_error = javaMethod("isError",execute_result);
  
  if result_error == 1
    error(javaMethod("getErrorMessage",execute_result)); 
    return
  endif
  
  if result_empty == 1
    warning("result is empty");
    retval  = cell(0,0);
    return
    
  endif
  
  rows = javaMethod("totalData",execute_result);
  
  first = javaMethod("getData",execute_result,0);
  
  cols = javaMethod("totalData",first);
  
  retval = cell(rows,cols);
  
  
  for i = 0 : (rows - 1)
  
    result_row = javaMethod("getData",execute_result,i);
    
    for j = 0 : (cols - 1)
    
      result_element = javaMethod("getData",result_row,j);
      
      retval{(i+1),(j+1)} = javaMethod("value",result_element);
    
    endfor
  
  endfor
  
endfunction