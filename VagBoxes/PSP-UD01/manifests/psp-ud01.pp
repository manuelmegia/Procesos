
include stdlib
# include apt
# include docker

file {'/home/vagrant/README':
    ensure => file,
    content => "Máquina que implanta el servicio web conversions (DAM2-SGE-UD01)\n",
    owner => 'vagrant',
    mode => '0444',
}

$packages = [
    'vim',
    'tree',
    'mlocate',
    'python3',
    'python3-flask'
    # 'snmp',
    # 'build-essential',
    # 'git',
    # 'docker',
    # 'docker-compose'
]

package {$packages:
    ensure => installed,
}

file {"/lib/systemd/system/conversions.service":
  ensure => "present",
  source => "/vagrant/Conversions/conversions.service"
}

file {"/etc/systemd/system/multi-user.target.wants/conversions.service":
  ensure => "link",
  target => "/lib/systemd/system/conversions.service"
}

exec {"updatedb.mlocate":
  command => "/usr/bin/updatedb.mlocate",
  subscribe => Package["mlocate"]
}

exec{"systemd-reload":
  command => "/usr/bin/systemctl daemon-reload",
  subscribe => File["/etc/systemd/system/multi-user.target.wants/conversions.service"]
}

service {"conversions":
  ensure => "running",
  enable => "true"
}

