#!/usr/bin/env ruby
(ARGV[0].to_i).times do |n|
  (ARGV[0].to_i-n).times {print " "}
  k = n
  (n+1).times do |n|
    print `java CLIMain #{k} #{n}`.chomp! + " "
  end
  puts
end