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

function retval = radityopw_query_non_select (sql)

  source("radityopw_query_init.m");
  
  wrapper = radityopw_query_connect(radityopw_query_driver,radityopw_query_url,radityopw_query_user,radityopw_query_password);
  retval = javaMethod("execute",wrapper,sql);
endfunction
